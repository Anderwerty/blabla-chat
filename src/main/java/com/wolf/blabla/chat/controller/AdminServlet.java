package com.wolf.blabla.chat.controller;

import com.wolf.blabla.chat.command.Command;
import com.wolf.blabla.chat.context.ApplicationContextInjector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class AdminServlet extends HttpServlet {
    private final Map<String, Command> commandNameToCommand;
    private final Command defaultCommand;

    public AdminServlet() {
        final ApplicationContextInjector injector = ApplicationContextInjector.getInstance();
        this.commandNameToCommand = injector.getUserCommands();
        this.defaultCommand = request -> "view/problem.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String commandName = req.getParameter("command");

        //can be null. Optional vs if-else
//        final String page = Optional.ofNullable(commandNameToCommand.get(commandName))
//                .map(x -> x.execute(req))
//                .orElseThrow(() -> new RuntimeException());

        final String page = commandNameToCommand.getOrDefault(commandName, defaultCommand).execute(req);

        req.getRequestDispatcher(page).forward(req, resp);
    }
}
