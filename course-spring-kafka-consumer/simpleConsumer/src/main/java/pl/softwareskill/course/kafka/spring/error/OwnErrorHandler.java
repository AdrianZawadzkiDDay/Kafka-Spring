package pl.softwareskill.course.kafka.spring.error;

import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.core.log.LogAccessor;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.ListenerUtils;

public class OwnErrorHandler implements ErrorHandler {
    private static final LogAccessor LOGGER = new LogAccessor(LogFactory.getLog(OwnErrorHandler.class));

    public OwnErrorHandler() {
    }

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.error("Wrong message invoked OwnErrorHandler.class");

        LOGGER.error("Consumer record value: " + ListenerUtils.recordToString(consumerRecord));
    }
}
