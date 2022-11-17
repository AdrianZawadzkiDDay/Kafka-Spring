package pl.softwareskill.course.kafka.spring.consumer.infra;

import java.util.Map;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.softwareskill.course.kafka.spring.consumer.domain.MessageRead;
import pl.softwareskill.course.kafka.spring.consumer.domain.MessageReadRepository;

@Configuration
class MessageReadRepositoryConfig {

    @Bean
    public MessageReadRepository messageReadRepository(Map<UUID, MessageRead> messagesRead) {
        return new MessageReadInMemoryRepository(messagesRead);
    }

//    @Bean
//    public MessageReadRepository messageReadRepository() {
//        return new InMemoryMessageReadRepository(new ConcurrentHashMap<>());
//    }
}
