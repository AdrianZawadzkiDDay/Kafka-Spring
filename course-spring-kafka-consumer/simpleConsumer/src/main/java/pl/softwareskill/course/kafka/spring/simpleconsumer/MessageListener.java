package pl.softwareskill.course.kafka.spring.simpleconsumer;

import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.softwareskill.course.kafka.spring.event.MessageReadEvent;
import pl.softwareskill.course.kafka.spring.simpleconsumer.domain.MessageReadConsumer;
import static pl.softwareskill.course.kafka.spring.simpleconsumer.infra.MessageReadConst.Groups.MESSAGE_READ_GROUP;
import static pl.softwareskill.course.kafka.spring.simpleconsumer.infra.MessageReadConst.Listeners.MESSAGE_READ_LISTENER_CONTAINER_FACTORY;
import static pl.softwareskill.course.kafka.spring.simpleconsumer.infra.MessageReadConst.Topics.MESSAGE_READ_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Component
class MessageListener {

    MessageReadConsumer messageReadConsumer;

    @KafkaListener(topics = MESSAGE_READ_EVENTS, groupId = MESSAGE_READ_GROUP, containerFactory = MESSAGE_READ_LISTENER_CONTAINER_FACTORY)
    public void handleMessage(MessageReadEvent event) {

        log.info("[READ MESSAGE] message {}", event.toString());
        messageReadConsumer.consume(event);
    }
}