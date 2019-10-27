package com.wolf.blabla.chat.dao.impl;

import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.TopicDao;
import com.wolf.blabla.chat.entity.TopicEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TopicDaoImpl extends AbstractCrudDaoImpl<TopicEntity> implements TopicDao {

    private static final String SAVE_QUERY = "INSERT INTO users (name, surname,email,password) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * from topics WHERE id = ?";
    private static final String FIND_ALL_QUERY = "";
    private static final String UPDATE_QUERY = "";
    private static final String DELETE_BY_ID_QUERY = "";

    public TopicDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public List<TopicEntity> findByTitle(String title) {
        return null;
    }

    @Override
    public List<TopicEntity> findByAuthor(String author) {
        return null;
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, TopicEntity entity) throws SQLException {
        preparedStatement.setLong(1, entity.getAuthor().getId());
        preparedStatement.setString(2, entity.getTitle());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, TopicEntity entity) throws SQLException {

    }

    @Override
    protected TopicEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return TopicEntity.builder()
                .withId(resultSet.getLong("id"))
                .withTitle(resultSet.getString("title"))
                .build();
    }
}
