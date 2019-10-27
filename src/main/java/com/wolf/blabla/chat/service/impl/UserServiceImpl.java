package com.wolf.blabla.chat.service.impl;

import com.wolf.blabla.chat.dao.UserDao;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.UserService;
import com.wolf.blabla.chat.service.exception.EntityAlreadyExistException;
import com.wolf.blabla.chat.service.mapper.UserMapper;
import com.wolf.blabla.chat.service.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    private final Validator<User> validator;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper, Validator<User> validator) {
        this.userDao = userDao;
        this.userMapper = userMapper;
        this.validator = validator;
    }

    @Override
    public void register(User user) {
        validator.validate(user);

        userDao.findByEmail(user.getEmail()).orElseThrow(() -> new EntityAlreadyExistException(401));
        userDao.save(userMapper.mapUserToUserEntity(user));
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll().stream()
                .map(userMapper::mapUserEntityToUser)
                .collect(Collectors.toList());
    }



}
