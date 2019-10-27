package com.wolf.blabla.chat.service.impl;

import com.wolf.blabla.chat.dao.MessageDao;
import com.wolf.blabla.chat.dao.TopicDao;
import com.wolf.blabla.chat.domain.Message;
import com.wolf.blabla.chat.domain.Topic;
import com.wolf.blabla.chat.domain.User;
import com.wolf.blabla.chat.entity.TopicEntity;
import com.wolf.blabla.chat.service.MessageService;
import com.wolf.blabla.chat.service.mapper.TopicMapper;
import com.wolf.blabla.chat.service.mapper.UserMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MessageServiceImpl implements MessageService {
    private final MessageDao messageDao;
    private final TopicDao topicDao;
    private final UserMapper userMapper;
    private final TopicMapper topicMapper;

    public MessageServiceImpl(MessageDao messageDao, TopicDao topicDao, UserMapper userMapper, TopicMapper topicMapper) {
        this.messageDao = messageDao;
        this.topicDao = topicDao;
        this.userMapper = userMapper;
        this.topicMapper = topicMapper;
    }

    @Override
    public List<Topic> createTopic(Topic topic, User user) {
        final TopicEntity entity = TopicEntity.builder()
                .withTitle(topic.getTitle())
                .withAuthor(userMapper.mapUserToUserEntity(user))
                .build();

        topicDao.save(entity);

        return topicDao.findByAuthor(user.getId()).stream()
                .map(topicMapper::mapTopicEntityToTopic)
                .collect(toList());
    }

    @Override
    public void sendMessage(Message message, Topic topic, User user) {

    }

}
