package com.wolf.blabla.chat.command.user;

import com.wolf.blabla.chat.command.Command;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class RegisterCommand implements Command {
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //Session
        final String name = (String) request.getAttribute("name");
        final String email = (String) request.getAttribute("email");

        final String password1 = (String) request.getAttribute("password1");
        final String password2 = (String) request.getAttribute("password2");

        if (!Objects.equals(password1, password2)) {
            return "view/register.jsp";
        }

        final User user = User.builder()
                .withEmail(email)
                .withName(name)
                .withPassword(password1)
                .build();

        userService.register(user);

        return "view/login.jsp";
    }
}
