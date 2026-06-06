package com.twinkal.ocidocassistant.producer;

import com.twinkal.ocidocassistant.dto.DocumentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DocumentProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public DocumentProducer(
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DocumentEvent event) {

        kafkaTemplate.send(
                "document-upload-topic",
                event.documentPath()
        );
    }
}
