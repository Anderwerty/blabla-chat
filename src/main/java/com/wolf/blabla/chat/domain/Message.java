package com.wolf.blabla.chat.domain;

public class Message {
    private Long id;
    private Topic topic;
    private User author;
    private String title;
    private String context;

    public Message(Builder builder) {
        this.id = builder.id;
        this.topic = builder.topic;
        this.author = builder.author;
        this.title = builder.title;
        this.context = builder.context;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public static class Builder {
        private Long id;
        private Topic topic;
        private User author;
        private String title;
        private String context;

        private Builder() {

        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTopic(Topic topic) {
            this.topic = topic;
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

        public Builder withContext(String context) {
            this.context = context;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
