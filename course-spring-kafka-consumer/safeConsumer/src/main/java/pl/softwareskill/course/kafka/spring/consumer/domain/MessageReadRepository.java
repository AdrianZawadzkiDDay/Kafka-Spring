package pl.softwareskill.course.kafka.spring.consumer.domain;

import java.util.UUID;

public interface MessageReadRepository {

    boolean exists(final UUID eventId);

    void save(final MessageRead messageRead);
}