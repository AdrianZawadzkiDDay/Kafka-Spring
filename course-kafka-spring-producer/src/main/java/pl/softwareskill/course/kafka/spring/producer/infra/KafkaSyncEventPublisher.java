package pl.softwareskill.course.kafka.spring.producer.infra;

import java.util.concurrent.ExecutionException;
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
public class KafkaSyncEventPublisher implements EventPublisher {

    KafkaTemplate kafkaTemplate;

    @Override
    public void send(final InternalEvent event) {
        final var producerRecord = new ProducerRecord<>(MESSAGE_READ_EVENTS, event.getKey(), event);
        try {
            final var sendResult = kafkaTemplate.send(producerRecord);
            kafkaTemplate.flush();
            sendResult.get();
            log.info("Send message");
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sending interrupted", e);
        } catch (final KafkaException | ExecutionException e) {
            log.error("There was error while synchronous send event to Kafka cluster", e);
        }
    }
}
