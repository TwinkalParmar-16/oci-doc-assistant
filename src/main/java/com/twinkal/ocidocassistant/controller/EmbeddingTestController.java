package com.twinkal.ocidocassistant.controller;

import com.twinkal.ocidocassistant.service.EmbeddingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbeddingTestController {

    private final EmbeddingService embeddingService;

    public EmbeddingTestController(
            EmbeddingService embeddingService
    ) {
        this.embeddingService = embeddingService;
    }

    @GetMapping("/test-embedding")
    public String test() {

        float[] vector =
                embeddingService.generateEmbedding(
                        "Oracle Cloud Infrastructure"
                );

        return "Vector size = " + vector.length;
    }
}