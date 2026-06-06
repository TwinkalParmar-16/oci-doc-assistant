package com.twinkal.ocidocassistant.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "document_chunks")
public class DocumentChunk {

    @Id
    private String id;

    private String documentName;

    private Integer chunkNumber;

    private String content;

    public DocumentChunk() {
    }

    public DocumentChunk(
            String documentName,
            Integer chunkNumber,
            String content
    ) {
        this.documentName = documentName;
        this.chunkNumber = chunkNumber;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public Integer getChunkNumber() {
        return chunkNumber;
    }

    public String getContent() {
        return content;
    }
}