package com.wolf.blabla.chat;

import com.wolf.blabla.chat.context.ApplicationContextInjector;
import com.wolf.blabla.chat.service.UserService;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContextInjector injector = ApplicationContextInjector.getInstance();
        final UserService userService = injector.getUserService();

        userService.findAll().forEach(System.out::println);

    }
}
