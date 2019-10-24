package com.wolf.blabla.chat.dao;

import com.wolf.blabla.chat.entity.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User, Long> {
    Optional<User> findByEmail(String email);

}
