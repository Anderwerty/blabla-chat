package com.wolf.blabla.chat.dao.impl;

import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.TopicDao;
import com.wolf.blabla.chat.entity.Topic;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TopicDaoImpl extends AbstractCrudDaoImpl<Topic> implements TopicDao {
    private static final Logger LOGGER = Logger.getLogger(TopicDaoImpl.class);
    private static final String FIND_BY_ID_QUERY = "SELECT * from topics WHERE id = ?";

    public TopicDaoImpl(DBConnector connector) {
        super(connector);
    }

    @Override
    public List<Topic> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Topic> findByAuthor(String author) {
        return null;
    }

    @Override
    public Topic save(Topic entity) {
        return null;
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return findById(id, FIND_BY_ID_QUERY);
    }

    @Override
    protected Optional<Topic> mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return resultSet.next() ?
                Optional.ofNullable(Topic.builder()
                        .withId(resultSet.getLong("id"))
                        .withTitle(resultSet.getString("title"))
                        .build())
                : Optional.empty();
    }

    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public void update(Topic entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAllByIds(Set<Long> ids) {

    }
}
