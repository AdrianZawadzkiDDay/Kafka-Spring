package pl.softwareskill.course.kafka.spring.producer.domain;

import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.softwareskill.course.kafka.spring.event.MessageReadEvent;
import pl.softwareskill.course.kafka.spring.producer.web.MessageReadRequest;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MessageReadFacade {

    EventPublisher eventPublisher;

    public void sendEvent(final MessageReadRequest messageReadRequest) {
        final var eventValue = MessageReadEvent.fromMessageReadRequest(messageReadRequest);
        eventPublisher.send(eventValue);
    }
}
