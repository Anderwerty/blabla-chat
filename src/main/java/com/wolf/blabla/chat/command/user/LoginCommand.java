package com.wolf.blabla.chat.command.user;

import com.wolf.blabla.chat.command.Command;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String email = (String) request.getAttribute("email");
        final String password = (String) request.getAttribute("password");

        final User user = userService.login(email, password);

        final HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "view/profile.jsp";
    }
}
