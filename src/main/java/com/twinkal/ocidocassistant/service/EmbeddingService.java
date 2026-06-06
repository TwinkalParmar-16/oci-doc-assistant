package com.twinkal.ocidocassistant.service;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
public class EmbeddingService {

    private final AllMiniLmL6V2EmbeddingModel model =
            new AllMiniLmL6V2EmbeddingModel();

    public float[] generateEmbedding(String text) {

        Embedding embedding =
                model.embed(text).content();

        return embedding.vector();
    }
}