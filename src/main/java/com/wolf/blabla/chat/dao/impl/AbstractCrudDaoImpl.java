package com.wolf.blabla.chat.dao.impl;

import com.wolf.blabla.chat.dao.CrudDao;
import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.DataBaseRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudDaoImpl.class);
    private static final BiConsumer<PreparedStatement, String> STING_CONSUMER
            = (PreparedStatement pr, String param) -> {
        try {
            pr.setString(1, param);
        } catch (SQLException e) {
            throw new DataBaseRuntimeException(e);
        }
    };

    private static final BiConsumer<PreparedStatement, Long> LONG_CONSUMER
            = (PreparedStatement pr, Long param) -> {
        try {
            pr.setLong(1, param);
        } catch (SQLException e) {
            throw new DataBaseRuntimeException(e);
        }
    };

    private final DBConnector connector;
    private final String saveQuery;
    private final String findByIdQuery;
    private final String findAllQuery;
    private final String updateQuery;
    private final String deleteByIdQuery;

    public AbstractCrudDaoImpl(DBConnector connector, String saveQuery, String findByIdQuery,
                               String findAllQuery, String updateQuery, String deleteByIdQuery) {
        this.connector = connector;
        this.saveQuery = saveQuery;
        this.findByIdQuery = findByIdQuery;
        this.findAllQuery = findAllQuery;
        this.updateQuery = updateQuery;
        this.deleteByIdQuery = deleteByIdQuery;
    }

    @Override
    public void save(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveQuery)) {

            insert(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            LOGGER.error("Insertion is failed", e);
            throw new DataBaseRuntimeException("Insertion is failed", e);
        }
    }

    @Override
    public Optional<E> findById(Long id) {
        return findByLongParam(id, findByIdQuery);
    }

    @Override
    public List<E> findAll() {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<E> entities = new ArrayList<>();
                while (resultSet.next()) {
                    entities.add(mapResultSetToEntity(resultSet));
                }
                return entities;
            }
        } catch (SQLException e) {
//            LOGGER.error("");
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    public void update(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            updateValues(preparedStatement, entity);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            LOGGER.error("Update is failed", e);
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllByIds(Set<Long> longs) {
        throw new UnsupportedOperationException();
    }

    protected Optional<E> findByLongParam(Long id, String query) {
        return findByParam(id, query, LONG_CONSUMER);
    }

    protected Optional<E> findByStringParam(String param, String query) {
        return findByParam(param, query, STING_CONSUMER);
    }

    private <P> Optional<E> findByParam(P param, String query, BiConsumer<PreparedStatement, P> consumer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            consumer.accept(preparedStatement, param);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() ? Optional.ofNullable(mapResultSetToEntity(resultSet)) : Optional.empty();
            }
        } catch (SQLException e) {
//            LOGGER.error("");
            throw new DataBaseRuntimeException(e);
        }
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract void insert(PreparedStatement preparedStatement, E entity) throws SQLException;

    protected abstract void updateValues(PreparedStatement preparedStatement, E entity) throws SQLException;
}
