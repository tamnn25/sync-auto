package org.example.syncautomation.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSyncConsumer {
    private static final Logger logger = LogManager.getLogger(MessageSyncConsumer.class);

    @KafkaListener(
            topics = "topic01",
            groupId = "1",
            autoStartup = "true",
            concurrency = "2"
    )
    public void consumeChanges(
            @Payload(required = false) String message,
            Acknowledgment ack
    ) {

        System.out.println(message);
        logger.info("Received message changes {}", message);
    }

}
