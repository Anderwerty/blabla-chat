package com.wolf.blabla.chat.service;

import com.wolf.blabla.chat.domain.User;

import java.util.List;

public interface UserService {

    void register(User user);

    List<User> findAll();

}
