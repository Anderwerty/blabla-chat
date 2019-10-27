package com.wolf.blabla.chat.service.validator;

import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.service.exception.InvalidEmailException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserValidatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final UserValidator userValidator = new UserValidator();

    @Test
    public void validateShouldNotThrowExceptionForValidUserEmail() {
        final User user = initUser("alex@gmail.com");

        userValidator.validate(user);
    }

    @Test
    public void validateShouldThrowExceptionForNullUserEmail() {
        expectedException.expect(InvalidEmailException.class);
        final User user = initUser(null);

        userValidator.validate(user);
    }

    @Test
    public void validateShouldThrowExceptionForInvalidUserEmail(){
        expectedException.expect(InvalidEmailException.class);
        final User user = initUser("email");

        userValidator.validate(user);
    }

    private static User initUser(String email) {
        return User.builder()
                .withEmail(email)
                .build();
    }

}