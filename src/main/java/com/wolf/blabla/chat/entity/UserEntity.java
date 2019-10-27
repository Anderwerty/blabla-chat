package com.wolf.blabla.chat.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserEntity {
    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Set<Role> roles;
    private final List<MessageEntity> messageEntities;

    private UserEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.roles = builder.roles;
        this.messageEntities = builder.messageEntities;
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

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) &&
                Objects.equals(name, userEntity.name) &&
                Objects.equals(surname, userEntity.surname) &&
                Objects.equals(email, userEntity.email) &&
                Objects.equals(password, userEntity.password) &&
                Objects.equals(roles, userEntity.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, roles);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private Set<Role> roles;
        private List<MessageEntity> messageEntities;

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

        public Builder withMessages(List<MessageEntity> messageEntities) {
            this.messageEntities = messageEntities;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
