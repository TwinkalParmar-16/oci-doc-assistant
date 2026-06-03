package com.twinkal.ocidocassistant.service;

import org.springframework.stereotype.Service;

@Service
public class HealthService {
    public String getStatus() {
        return "OCI Twinkal Documentation Assistant Running";
    }
}

