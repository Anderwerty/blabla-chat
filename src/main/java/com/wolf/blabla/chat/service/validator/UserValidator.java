package com.wolf.blabla.chat.service.validator;

import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.exception.InvalidEmailException;

import java.util.regex.Pattern;


public class UserValidator implements Validator<User> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

    @Override
    public void validate(User entity) {
        final boolean matches = EMAIL_PATTERN.matcher(entity.getEmail()).matches();
        if(!matches){
            throw new InvalidEmailException();
        }
    }
}


