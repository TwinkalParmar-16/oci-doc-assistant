package com.twinkal.ocidocassistant.controller;

import com.twinkal.ocidocassistant.service.QdrantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QdrantTestController {

    private final QdrantService qdrantService;

    public QdrantTestController(
            QdrantService qdrantService
    ) {
        this.qdrantService = qdrantService;
    }

    @GetMapping("/test-qdrant")
    public String test() {

        return qdrantService
                .getClient()
                .toString();
    }
}