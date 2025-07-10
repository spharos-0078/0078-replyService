package com.pieceofcake.reply_service.kafka.producer;

import com.pieceofcake.reply_service.kafka.event.AlertKafkaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, AlertKafkaEvent> alertkafkaTemplate;

    public void updateReplyAlertEvent(AlertKafkaEvent alertKafkaEvent) {
        log.info("Sending update reply comment: {}", alertKafkaEvent);
        CompletableFuture<SendResult<String, AlertKafkaEvent>> future =
                alertkafkaTemplate.send("reply-comment-alarm", alertKafkaEvent);
    }
}