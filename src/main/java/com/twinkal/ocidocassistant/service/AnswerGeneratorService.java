package com.twinkal.ocidocassistant.service;

import com.twinkal.ocidocassistant.model.DocumentChunk;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerGeneratorService {

    public String generateAnswer(
            String question,
            List<DocumentChunk> chunks
    ) {

        if (chunks.isEmpty()) {
            return "No relevant information found.";
        }

        return chunks.stream()
                .map(DocumentChunk::getContent)
                .reduce("", (a, b) -> a + "\n" + b);
    }
}