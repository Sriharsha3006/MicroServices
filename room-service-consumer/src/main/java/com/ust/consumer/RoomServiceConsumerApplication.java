package com.ust.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;



@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
@RefreshScope
public class RoomServiceConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RoomServiceConsumerApplication.class, args);
	}
}
