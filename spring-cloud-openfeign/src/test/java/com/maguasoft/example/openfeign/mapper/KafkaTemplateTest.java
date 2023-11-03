package com.maguasoft.example.openfeign.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@Configuration
public class KafkaTemplateTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "test_topic")
    public void testConsumer(String content) {
        log.info(content);
    }

    @Test
    public void testProducer() {
        kafkaTemplate.send("test_topic", "fffffffffffffffffffffffffff");
    }
}
