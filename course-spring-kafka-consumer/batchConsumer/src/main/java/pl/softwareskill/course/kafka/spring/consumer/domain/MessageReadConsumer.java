package pl.softwareskill.course.kafka.spring.consumer.domain;

import pl.softwareskill.course.kafka.spring.event.MessageReadEvent;

public interface MessageReadConsumer {

    void consume(final MessageReadEvent event, final String topic, final Integer partition, final Long offset);
}
