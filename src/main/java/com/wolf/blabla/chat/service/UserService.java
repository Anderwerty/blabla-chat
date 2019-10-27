package com.wolf.blabla.chat.service;

import com.wolf.blabla.chat.domain.User;

import java.util.List;

public interface UserService {

    void register(User user);

    User login(String email, String password);

    List<User> findAll();

}
