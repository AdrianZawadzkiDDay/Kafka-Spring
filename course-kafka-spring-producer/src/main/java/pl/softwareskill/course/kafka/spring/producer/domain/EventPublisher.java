package pl.softwareskill.course.kafka.spring.producer.domain;

public interface EventPublisher<E extends InternalEvent> {

    void send(final E event);
}
