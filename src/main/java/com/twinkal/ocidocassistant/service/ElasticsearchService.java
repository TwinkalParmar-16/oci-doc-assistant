package com.twinkal.ocidocassistant.service;

import com.twinkal.ocidocassistant.model.DocumentChunk;
import com.twinkal.ocidocassistant.repository.DocumentChunkRepository;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchService {

    private final DocumentChunkRepository repository;

    public ElasticsearchService(
            DocumentChunkRepository repository
    ) {
        this.repository = repository;
    }

    public void saveChunk(
            String documentName,
            Integer chunkNumber,
            String content
    ) {

        repository.save(
                new DocumentChunk(
                        documentName,
                        chunkNumber,
                        content
                )
        );
    }
}