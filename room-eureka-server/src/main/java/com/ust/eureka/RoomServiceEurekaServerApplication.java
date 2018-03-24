package com.ust.eureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RoomServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomServiceEurekaServerApplication.class, args);
	}
}
