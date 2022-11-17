package pl.softwareskill.course.kafka.spring.consumer.infra;

import java.util.Map;
import java.util.UUID;
import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.softwareskill.course.kafka.spring.consumer.domain.MessageRead;
import pl.softwareskill.course.kafka.spring.consumer.domain.MessageReadRepository;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
class MessageReadInMemoryRepository implements MessageReadRepository {

    Map<UUID, MessageRead> messagesRead;

    @Override
    public boolean exists(UUID eventId) {
        return messagesRead.keySet()
                .stream()
                .anyMatch(x -> x.equals(eventId));
    }

    @Override
    public void save(MessageRead messageRead) {
        messagesRead.put(messageRead.getEventId(), messageRead);
    }
}