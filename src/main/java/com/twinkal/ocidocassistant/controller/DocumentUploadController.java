package com.twinkal.ocidocassistant.controller;

import com.twinkal.ocidocassistant.dto.DocumentEvent;
import com.twinkal.ocidocassistant.dto.DocumentUploadResponse;
import com.twinkal.ocidocassistant.producer.DocumentProducer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequestMapping("/api/documents")
public class DocumentUploadController {

    private final DocumentProducer producer;

    public DocumentUploadController(
            DocumentProducer producer
    ) {
        this.producer = producer;
    }

    @PostMapping("/upload")
    public DocumentUploadResponse upload(
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        Path uploadDir = Paths.get("uploads");

        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        Path uploadPath =
                uploadDir.resolve(Objects.requireNonNull(file.getOriginalFilename()));

        Files.copy(
                file.getInputStream(),
                uploadPath,
                StandardCopyOption.REPLACE_EXISTING
        );

        producer.publish(
                new DocumentEvent(
                        file.getOriginalFilename(),
                        uploadPath.toString()
                )
        );

        return new DocumentUploadResponse(
                file.getOriginalFilename(),
                "PUBLISHED_TO_KAFKA"
        );
    }
}