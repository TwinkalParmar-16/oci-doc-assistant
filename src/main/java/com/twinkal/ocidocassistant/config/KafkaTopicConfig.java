package com.twinkal.ocidocassistant.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic documentTopic() {
        return new NewTopic(
                "document-upload-topic",
                1,
                (short) 1
        );
    }
}
