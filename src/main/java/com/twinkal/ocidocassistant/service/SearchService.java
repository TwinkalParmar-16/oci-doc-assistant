package com.twinkal.ocidocassistant.service;

import com.twinkal.ocidocassistant.model.DocumentChunk;
import com.twinkal.ocidocassistant.repository.DocumentChunkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final DocumentChunkRepository repository;

    public SearchService(
            DocumentChunkRepository repository
    ) {
        this.repository = repository;
    }

    public List<DocumentChunk> search(
            String question
    ) {

        List<DocumentChunk> chunks =
                repository.findByContentContaining(
                        question
                );

        return chunks.stream()
                .limit(3)
                .toList();
    }
}