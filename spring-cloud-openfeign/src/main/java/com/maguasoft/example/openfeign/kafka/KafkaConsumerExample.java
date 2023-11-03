package com.maguasoft.example.openfeign.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerExample {

    @KafkaListener(topics = "test_topic")
    public void onMessage(String content) {
        log.info("KafkaConsumerExample : {}", content);
    }
}
