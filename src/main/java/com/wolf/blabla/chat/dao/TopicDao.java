package com.wolf.blabla.chat.dao;

import com.wolf.blabla.chat.entity.TopicEntity;

import java.util.List;

public interface TopicDao extends CrudDao<TopicEntity, Long> {
    List<TopicEntity> findByTitle(String title);

    List<TopicEntity> findByAuthor(String author);
}
