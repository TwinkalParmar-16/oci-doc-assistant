package com.twinkal.ocidocassistant.service;

import io.qdrant.client.QdrantClient;
import io.qdrant.client.QdrantGrpcClient;
import org.springframework.stereotype.Service;

@Service
public class QdrantService {

    private final QdrantClient client;

    public QdrantService() {

        this.client =
                new QdrantClient(
                        QdrantGrpcClient.newBuilder(
                                "localhost",
                                6334,
                                false
                        ).build()
                );
    }

    public QdrantClient getClient() {
        return client;
    }
}