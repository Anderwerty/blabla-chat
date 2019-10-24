package com.wolf.blabla.chat.dao.impl;

import com.wolf.blabla.chat.dao.CrudDao;
import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.DataBaseRuntimeException;
import com.wolf.blabla.chat.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E,Long> {
    private static final Logger LOGGER = Logger.getLogger(AbstractCrudDaoImpl.class);
    private static final String FIND_BY_ID_QUERY = "";

    protected final DBConnector connector;

    public AbstractCrudDaoImpl(DBConnector connector) {
        this.connector = connector;
    }

    protected Optional<E> findById(Long id, String query){
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            final ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToEntity(resultSet);
        } catch (SQLException e) {
            LOGGER.error("");
            throw new DataBaseRuntimeException(e);
        }
    }

    protected abstract Optional<E> mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
