package com.twinkal.ocidocassistant.controller;

import com.twinkal.ocidocassistant.dto.QuestionRequest;
import com.twinkal.ocidocassistant.dto.QuestionResponse;
import com.twinkal.ocidocassistant.model.DocumentChunk;
import com.twinkal.ocidocassistant.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final SearchService searchService;

    public QuestionController(
            SearchService searchService
    ) {
        this.searchService = searchService;
    }

    @PostMapping
    public QuestionResponse ask(
            @RequestBody QuestionRequest request
    ) {

        List<DocumentChunk> chunks =
                searchService.search(
                        request.question()
                );

        List<String> results =
                chunks.stream()
                        .map(DocumentChunk::getContent)
                        .toList();

        return new QuestionResponse(
                request.question(),
                results
        );
    }
}