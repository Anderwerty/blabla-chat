package com.wolf.blabla.chat;

import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.UserDao;
import com.wolf.blabla.chat.dao.impl.UserDaoImpl;
import com.wolf.blabla.chat.entity.UserEntity;
import com.wolf.blabla.chat.service.PasswordEncoder;
import com.wolf.blabla.chat.service.UserService;
import com.wolf.blabla.chat.service.impl.UserServiceImpl;
import com.wolf.blabla.chat.service.mapper.UserMapper;
import com.wolf.blabla.chat.service.validator.UserValidator;

public class ApplicationRunner {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector("database");
        UserDao userDao = new UserDaoImpl(connector);

        final UserService userService = new UserServiceImpl(userDao, new UserMapper(new PasswordEncoder()), new UserValidator());

        final UserEntity userEntity = userDao.findByEmail("alex@gmail.com").orElse(null);

        System.out.println(userEntity);

        final UserEntity userEntity1 = UserEntity.builder()
                .withName("Andrii")
                .withEmail("andrii@gmail.com")
                .withSurname("Shylin")
                .withPassword("password")
                .build();

//        userDao.save(userEntity1);

        final UserEntity userEntity2 = userDao.findByEmail("andrii@gmail.com").orElse(null);

        System.out.println(userEntity2);
        System.out.println("______________________________________");

        userService.findAll().forEach(System.out::println);

    }
}
