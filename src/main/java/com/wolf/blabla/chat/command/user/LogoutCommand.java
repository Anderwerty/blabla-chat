package com.wolf.blabla.chat.command.user;

import com.wolf.blabla.chat.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();

        return "view/login.jsp"; // or "view/index.jsp";
    }
}
