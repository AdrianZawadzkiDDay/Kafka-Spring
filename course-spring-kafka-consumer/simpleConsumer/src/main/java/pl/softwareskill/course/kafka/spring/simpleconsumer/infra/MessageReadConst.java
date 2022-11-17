package pl.softwareskill.course.kafka.spring.simpleconsumer.infra;

public interface MessageReadConst {

    interface Listeners {
        String MESSAGE_READ_LISTENER_CONTAINER_FACTORY = "concurrentKafkaListenerContainerFactory";
    }

    interface Groups {
        String MESSAGE_READ_GROUP = "${app.kafka.group-id}";
    }

    interface Topics {
        String MESSAGE_READ_EVENTS = "test-topic-72";
    }
}