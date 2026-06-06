package com.twinkal.ocidocassistant.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextChunkingService {

    public List<String> chunkText(String text) {

        int chunkSize = 1000;

        List<String> chunks =
                new ArrayList<>();

        for (int start = 0;
             start < text.length();
             start += chunkSize) {

            int end =
                    Math.min(
                            start + chunkSize,
                            text.length()
                    );

            chunks.add(
                    text.substring(start, end)
            );
        }

        return chunks;
    }
}