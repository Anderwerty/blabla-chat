package com.wolf.blabla.chat.controller;

import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.impl.UserDaoImpl;
import com.wolf.blabla.chat.service.PasswordEncoder;
import com.wolf.blabla.chat.service.UserService;
import com.wolf.blabla.chat.service.impl.UserServiceImpl;
import com.wolf.blabla.chat.service.mapper.UserMapper;
import com.wolf.blabla.chat.service.validator.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl(new UserDaoImpl(new DBConnector("database")),
            new UserMapper(new PasswordEncoder()), new UserValidator());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/users.jsp");


    }
}
