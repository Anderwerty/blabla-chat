package com.wolf.blabla.chat.service.mapper;

import com.wolf.blabla.chat.domain.Role;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.entity.UserEntity;
import com.wolf.blabla.chat.service.PasswordEncoder;

import java.util.Optional;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User mapUserEntityToUser(UserEntity userEntity) {
        return User.builder()
                .withId(userEntity.getId())
                .withName(userEntity.getName())
                .withSurname(userEntity.getSurname())
                .withEmail(userEntity.getEmail())
                .withPassword(userEntity.getPassword())
                .withRoles(Optional.ofNullable(userEntity.getRoles()).orElse(emptySet()).stream()
                        .map(Enum::name)
                        .map(Role::valueOf)
                        .collect(toSet()))
                .build();
    }

    public UserEntity mapUserToUserEntity(User user) {
        return UserEntity.builder()
                .withId(user.getId())
                .withName(user.getName())
                .withSurname(user.getSurname())
                .withEmail(user.getEmail())
                .withPassword(passwordEncoder.encode(user.getPassword()))
                .withRoles(Optional.ofNullable(user.getRoles()).orElse(emptySet()).stream()
                        .map(Enum::name)
                        .map(com.wolf.blabla.chat.entity.Role::valueOf)
                        .collect(toSet()))
                .build();
    }

}
