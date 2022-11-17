package pl.softwareskill.course.kafka.spring.consumer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.softwareskill.course.kafka.spring.consumer.infra.StoreOffsetRegistry;

@Configuration
class MessageReadConfig {

    @Bean
    public MessageReadConsumer messageReadFacade(final MessageReadRepository messageReadRepository, final StoreOffsetRegistry storeOffsetRegistry) {
        return new MessageReadFacade(messageReadRepository, storeOffsetRegistry);
    }
}
