package pl.softwareskill.course.kafka.spring.producer.infra;

import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import pl.softwareskill.course.kafka.spring.producer.domain.EventPublisher;
import pl.softwareskill.course.kafka.spring.producer.domain.InternalEvent;
import static pl.softwareskill.course.kafka.spring.producer.infra.MessageReadConst.Topics.MESSAGE_READ_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class KafkaAsyncEventPublisher implements EventPublisher<InternalEvent> {

    KafkaTemplate<String, InternalEvent> kafkaTemplate;

    @Override
    public void send(final InternalEvent event) {
        try {
            final var producerRecord = new ProducerRecord<>(MESSAGE_READ_EVENTS, event.getKey(), event);
            kafkaTemplate.send(producerRecord);
            log.info("send message");
        } catch (KafkaException e) {
            log.error("There was error while asynchronous send event to Kafka cluster", e);
        }
    }
}
