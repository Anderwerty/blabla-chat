package com.wolf.blabla.chat.entity;

import java.util.List;
import java.util.Set;

public class TopicEntity {
    private final Long id;
    private final UserEntity author;
    private final String title;
    private final Set<UserEntity> members;
    private final List<MessageEntity> messageEntities;

    private TopicEntity(Builder builder) {
        this.id = builder.id;
        this.author = builder.author;
        this.title = builder.title;
        this.members = builder.members;
        this.messageEntities = builder.messageEntities;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Set<UserEntity> getMembers() {
        return members;
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public static class Builder {
        private Long id;
        private UserEntity author;
        private String title;
        private Set<UserEntity> members;
        private List<MessageEntity> messageEntities;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withAuthor(UserEntity author) {
            this.author = author;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withMembers(Set<UserEntity> members) {
            this.members = members;
            return this;
        }

        public Builder withMessages(List<MessageEntity> messageEntities) {
            this.messageEntities = messageEntities;
            return this;
        }

        public TopicEntity build() {
            return new TopicEntity(this);
        }
    }
}
