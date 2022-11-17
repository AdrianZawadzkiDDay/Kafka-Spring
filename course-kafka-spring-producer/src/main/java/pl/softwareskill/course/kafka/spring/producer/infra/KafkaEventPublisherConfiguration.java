package pl.softwareskill.course.kafka.spring.producer.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import pl.softwareskill.course.kafka.spring.producer.domain.EventPublisher;
import pl.softwareskill.course.kafka.spring.producer.domain.InternalEvent;

@Configuration
class KafkaEventPublisherConfiguration {

    @Bean
    EventPublisher kafkaAsyncEventPublisher(final KafkaTemplate<String, InternalEvent> kafkaTemplate) {
        return new KafkaAsyncEventPublisher(kafkaTemplate);
    }

    @Bean
    EventPublisher kafkaSyncEventPublisher(final KafkaTemplate<String, InternalEvent> kafkaTemplate) {
        return new KafkaSyncEventPublisher(kafkaTemplate);
    }
}
