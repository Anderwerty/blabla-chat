package com.wolf.blabla.chat.context;

import com.wolf.blabla.chat.command.Command;
import com.wolf.blabla.chat.command.user.LoginCommand;
import com.wolf.blabla.chat.command.user.LogoutCommand;
import com.wolf.blabla.chat.command.user.RegisterCommand;
import com.wolf.blabla.chat.dao.DBConnector;
import com.wolf.blabla.chat.dao.UserDao;
import com.wolf.blabla.chat.dao.impl.UserDaoImpl;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.PasswordEncoder;
import com.wolf.blabla.chat.service.UserService;
import com.wolf.blabla.chat.service.impl.UserServiceImpl;
import com.wolf.blabla.chat.service.mapper.UserMapper;
import com.wolf.blabla.chat.service.validator.UserValidator;
import com.wolf.blabla.chat.service.validator.Validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ApplicationContextInjector {
    private static final DBConnector DB_CONNECTOR = new DBConnector("database");

    private static final UserDao USER_DAO = new UserDaoImpl(DB_CONNECTOR);

    private static final PasswordEncoder PASSWORD_ENCODER = new PasswordEncoder();

    private static final UserMapper USER_MAPPER = new UserMapper(PASSWORD_ENCODER);

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, USER_MAPPER, USER_VALIDATOR);

    private static final Command LOGIN_COMMAND = new LoginCommand(USER_SERVICE);

    private static final Command LOGOUT_COMMAND = new LogoutCommand();

    private static final Command REGISTER_COMMAND = new RegisterCommand(USER_SERVICE);

    private static final Map<String, Command> USER_COMMAND_NAME_TO_COMMAND = initUserCommand();

    private static Map<String, Command> initUserCommand() {
        Map<String, Command> userCommandNameToCommand = new HashMap<>();
        userCommandNameToCommand.put("login", LOGIN_COMMAND);
        userCommandNameToCommand.put("logout", LOGOUT_COMMAND);
        userCommandNameToCommand.put("register", REGISTER_COMMAND);

        return Collections.unmodifiableMap(userCommandNameToCommand);
    }

    private static ApplicationContextInjector applicationContextInjector;

    private ApplicationContextInjector() {

    }

    public static ApplicationContextInjector getInstance() {
        if (applicationContextInjector == null) {
            synchronized (ApplicationContextInjector.class) {
                if (applicationContextInjector == null) {
                    applicationContextInjector = new ApplicationContextInjector();
                }
            }
        }
        return applicationContextInjector;
    }


    public UserService getUserService() {
        return USER_SERVICE;
    }

    public Map<String, Command> getUserCommands() {
        return USER_COMMAND_NAME_TO_COMMAND;
    }
}
