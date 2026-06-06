package com.twinkal.ocidocassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OciDocAssistantApplication {

	public static void main(String[] args) {

		SpringApplication.run(OciDocAssistantApplication.class, args);
	}

}
