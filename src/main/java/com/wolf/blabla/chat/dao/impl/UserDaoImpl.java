package com.wolf.blabla.chat.dao.impl;

import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.UserDao;
import com.wolf.blabla.chat.entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudDaoImpl<UserEntity> implements UserDao {

    private static final String SAVE_QUERY = "INSERT INTO users (name, surname,email,password) values(?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String UPDATE_QUERY = "UPDATE users SET name =?, surname=?, email=?, password=? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "UNSUPPORTED";
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email = ?";

    public UserDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return findByStringParam(email, FIND_BY_EMAIL_QUERY);
    }

    @Override
    protected UserEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return UserEntity.builder()
                .withId(resultSet.getLong("id"))
                .withName(resultSet.getString("name"))
                .withSurname(resultSet.getString("surname"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .build();
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, UserEntity entity) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurname());
        preparedStatement.setString(3, entity.getEmail());
        preparedStatement.setString(4, entity.getPassword());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, UserEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(5, entity.getId());
    }
}
