package com.twinkal.ocidocassistant.dto;

import java.util.List;

public record QuestionResponse(
        String question,
        List<String> chunks
) {
}