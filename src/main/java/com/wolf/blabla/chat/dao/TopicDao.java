package com.wolf.blabla.chat.dao;

import com.wolf.blabla.chat.entity.Topic;

import java.util.List;

public interface TopicDao extends CrudDao<Topic, Long> {
    List<Topic> findByTitle(String title);

    List<Topic> findByAuthor(String author);
}
