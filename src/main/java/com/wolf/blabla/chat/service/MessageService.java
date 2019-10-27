package com.wolf.blabla.chat.service;

import com.wolf.blabla.chat.domain.Message;
import com.wolf.blabla.chat.domain.Topic;
import com.wolf.blabla.chat.domain.User;

import java.util.List;

public interface MessageService {

    List<Topic> createTopic(Topic topic, User user);

    void sendMessage(Message message, Topic topic, User user);
}
