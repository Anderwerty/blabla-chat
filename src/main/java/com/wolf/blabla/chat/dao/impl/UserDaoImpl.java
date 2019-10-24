package com.wolf.blabla.chat.dao.impl;

import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.DataBaseRuntimeException;
import com.wolf.blabla.chat.dao.UserDao;
import com.wolf.blabla.chat.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserDaoImpl extends AbstractCrudDaoImpl<User> implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private static final String FIND_BY_EMAIL_QUERY = "SELECT * from users WHERE email = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT * from users WHERE id = ?";

    public UserDaoImpl(DBConnector connector) {
        super(connector);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_QUERY)) {
            preparedStatement.setString(1, email);
            final ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToEntity(resultSet);
        } catch (SQLException e) {
            LOGGER.error("");
            throw new DataBaseRuntimeException(e);
        }

    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return findById(id, FIND_BY_ID_QUERY);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAllByIds(Set<Long> longs) {

    }

    protected Optional<User> mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return resultSet.next() ?
                Optional.ofNullable(User.builder()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withSurname(resultSet.getString("surname"))
                        .withEmail(resultSet.getString("email"))
                        .withPassword(resultSet.getString("password"))
                        .build())
                : Optional.empty();
    }
}
