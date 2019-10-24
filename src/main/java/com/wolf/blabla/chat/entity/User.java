package com.wolf.blabla.chat.entity;

import java.util.List;
import java.util.Set;

public class User {
    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Set<Role> roles;
    private final List<Message> messages;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.roles = builder.roles;
        this.messages = builder.messages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private Set<Role> roles;
        private List<Message> messages;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public Builder withMessages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
