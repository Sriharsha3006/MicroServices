package com.ust.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RoomServiceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomServiceProducerApplication.class, args);
	}
}
