package com.maguasoft.example.openfeign.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerExample {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        kafkaTemplate.send("test_topic", "fffffffffffffffffffffffffffffffffff");
    }
}
