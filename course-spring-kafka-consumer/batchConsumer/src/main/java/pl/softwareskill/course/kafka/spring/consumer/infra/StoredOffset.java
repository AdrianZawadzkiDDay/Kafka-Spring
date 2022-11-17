package pl.softwareskill.course.kafka.spring.consumer.infra;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
class StoredOffset implements Serializable {

    String topicNamePartition;
    Long readOffset;

    public String getKey() {
        return topicNamePartition;
    }
}
