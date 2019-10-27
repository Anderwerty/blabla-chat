package com.wolf.blabla.chat.domain;

import com.wolf.blabla.chat.entity.MessageEntity;

import java.util.List;

public class Topic {
    private final Long id;
    private final Long authorId;
    private final String title;
    private final List<MessageEntity> messageEntities;

    public Topic(Long id, Long authorId, String title, List<MessageEntity> messageEntities) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.messageEntities = messageEntities;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }
}
