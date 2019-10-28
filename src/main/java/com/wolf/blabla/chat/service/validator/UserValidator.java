package com.wolf.blabla.chat.service.validator;

import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.exception.InvalidEmailException;

import java.util.Optional;
import java.util.regex.Pattern;


public class UserValidator implements Validator<User> {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");

    @Override
    public void validate(User entity) {
        Optional.ofNullable(entity)
                .map(User::getEmail)
                .filter(x -> EMAIL_PATTERN.matcher(x).matches())
                .orElseThrow(InvalidEmailException::new);
    }
}


