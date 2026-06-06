package com.twinkal.ocidocassistant.consumer;

import com.twinkal.ocidocassistant.service.ElasticsearchService;
import com.twinkal.ocidocassistant.service.PdfProcessingService;
import com.twinkal.ocidocassistant.service.TextChunkingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentConsumer {

    private final PdfProcessingService pdfProcessingService;
    private final TextChunkingService textChunkingService;
    private final ElasticsearchService elasticsearchService;

    public DocumentConsumer(
            PdfProcessingService pdfProcessingService,
            TextChunkingService textChunkingService, ElasticsearchService elasticsearchService
    ) {
        this.pdfProcessingService =
                pdfProcessingService;
        this.textChunkingService =
                textChunkingService;
        this.elasticsearchService = elasticsearchService;
    }

    @KafkaListener(
            topics = "document-upload-topic",
            groupId = "oci-doc-group"
    )
    public void consume(String filePath) {

        System.out.println(
                "Processing PDF : "
                        + filePath
        );

        String text =
                pdfProcessingService.extractText(
                        filePath
                );

        System.out.println(
                "Extracted Characters : "
                        + text.length()
        );

        System.out.println(
                text.substring(
                        0,
                        Math.min(text.length(), 500)
                )
        );

        List<String> chunks =
                textChunkingService.chunkText(text);

        System.out.println(
                "Total Chunks : "
                        + chunks.size()
        );

        for (int i = 0; i < chunks.size(); i++) {

            System.out.println(
                    "Chunk "
                            + i
                            + " Size : "
                            + chunks.get(i).length()
            );
        }

        for (int i = 0; i < chunks.size(); i++) {

            elasticsearchService.saveChunk(
                    filePath,
                    i,
                    chunks.get(i)
            );

            System.out.println(
                    "Saved chunk : " + i
            );
        }
    }
}