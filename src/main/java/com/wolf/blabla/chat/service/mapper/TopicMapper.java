package com.wolf.blabla.chat.service.mapper;

import com.wolf.blabla.chat.domain.Topic;
import com.wolf.blabla.chat.entity.TopicEntity;

public class TopicMapper {
    public TopicEntity mapTopicToTopicEntity(Topic topic) {

        return TopicEntity.builder().build();
    }

    public Topic mapTopicEntityToTopic(TopicEntity entity) {
        return new Topic(entity.getId(), null, entity.getTitle(), null);
    }
}
