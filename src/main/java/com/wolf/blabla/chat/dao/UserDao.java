package com.wolf.blabla.chat.dao;

import com.wolf.blabla.chat.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends CrudDao<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

}
