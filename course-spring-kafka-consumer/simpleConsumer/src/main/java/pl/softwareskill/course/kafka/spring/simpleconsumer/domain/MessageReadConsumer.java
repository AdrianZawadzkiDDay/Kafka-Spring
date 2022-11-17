package pl.softwareskill.course.kafka.spring.simpleconsumer.domain;

import pl.softwareskill.course.kafka.spring.event.MessageReadEvent;

public interface MessageReadConsumer {

    void consume(final MessageReadEvent event);
}