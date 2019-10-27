package com.wolf.blabla.chat.service.mapper;

import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.entity.UserEntity;
import com.wolf.blabla.chat.service.PasswordEncoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Collections.emptySet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    private static final String PASSWORD = "password";

    private static final long ID = 1L;

    private static final String NAME = "Name";

    private static final String SURNAME = "Surname";

    private static final String EMAIL = "email@gmail.com";

    @InjectMocks
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Before
    public void initMocks() {
        when(passwordEncoder.encode(eq(PASSWORD))).thenReturn(PASSWORD);
    }

    @Test
    public void mapUserEntityToUserShouldReturnUser() {
        final UserEntity userEntity = UserEntity.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withRoles(null)
                .build();

        final User user = userMapper.mapUserEntityToUser(userEntity);
        assertThat("mapping id is failed", user.getId(), is(ID));
        assertThat("mapping name is failed", user.getName(), is(NAME));
        assertThat("mapping surname is failed", user.getSurname(), is(SURNAME));
        assertThat("mapping email is failed", user.getEmail(), is(EMAIL));
        assertThat("mapping password is failed", user.getPassword(), is(PASSWORD));
        assertThat("mapping roles is failed", user.getRoles(), is(emptySet()));
    }

    @Test
    public void mapUserToUserEntityShouldReturnUserEntity(){
        final User user = User.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withRoles(null)
                .build();

        final UserEntity userEntity = userMapper.mapUserToUserEntity(user);
        assertThat("mapping id is failed", userEntity.getId(), is(ID));
        assertThat("mapping name is failed", userEntity.getName(), is(NAME));
        assertThat("mapping surname is failed", userEntity.getSurname(), is(SURNAME));
        assertThat("mapping email is failed", userEntity.getEmail(), is(EMAIL));
        assertThat("mapping password is failed", userEntity.getPassword(), is(PASSWORD));
        assertThat("mapping roles is failed", userEntity.getRoles(), is(emptySet()));  
    }
}