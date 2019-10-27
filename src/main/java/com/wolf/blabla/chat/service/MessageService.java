package com.wolf.blabla.chat.service;

import com.wolf.blabla.chat.domain.Message;
import com.wolf.blabla.chat.domain.Topic;

import java.util.List;

public interface MessageService {

    void createTopic(Topic topic);

    void addMembersToTpiC(Long topicId, List<Long> userIds);

    void sendMessage(Message message);
}
