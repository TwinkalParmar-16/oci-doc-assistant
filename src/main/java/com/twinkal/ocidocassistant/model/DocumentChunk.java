package com.twinkal.ocidocassistant.model;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getChunkNumber() {
        return chunkNumber;
    }

    public void setChunkNumber(Integer chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}