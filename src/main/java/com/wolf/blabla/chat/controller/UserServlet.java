package com.wolf.blabla.chat.controller;

import com.wolf.blabla.chat.context.ApplicationContextInjector;
import com.wolf.blabla.chat.domain.Role;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {

    private final UserService userService;

    public UserServlet() {
        ApplicationContextInjector injector = ApplicationContextInjector.getInstance();
        this.userService = injector.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User user = (User) req.getSession().getAttribute("user");
        final Role role = new ArrayList<>(user.getRoles()).get(0);
        //Better to use filters
        if (role != Role.ADMIN) {
            req.getRequestDispatcher("view/not_admin.jsp").forward(req, resp);
        }
        final List<User> users = userService.findAll();
        req.setAttribute("users", users);

        req.getRequestDispatcher("view/users.jsp").forward(req, resp);
    }
}
