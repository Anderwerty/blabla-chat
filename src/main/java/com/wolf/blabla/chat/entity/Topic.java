package com.wolf.blabla.chat.entity;

import java.util.List;
import java.util.Set;

public class Topic {
    private final Long id;
    private final User author;
    private final String title;
    private final Set<User> members;
    private final List<Message> messages;

    private Topic(Builder builder) {
        this.id = builder.id;
        this.author = builder.author;
        this.title = builder.title;
        this.members = builder.members;
        this.messages = builder.messages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Set<User> getMembers() {
        return members;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public static class Builder {
        private Long id;
        private User author;
        private String title;
        private Set<User> members;
        private List<Message> messages;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withAuthor(User author) {
            this.author = author;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withMembers(Set<User> members) {
            this.members = members;
            return this;
        }

        public Builder withMessages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public Topic build() {
            return new Topic(this);
        }
    }
}
