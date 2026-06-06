package com.twinkal.ocidocassistant.repository;

import com.twinkal.ocidocassistant.model.DocumentChunk;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentChunkRepository
        extends ElasticsearchRepository<DocumentChunk, String> {

    List<DocumentChunk> findByContentContaining(String keyword);
}