package com.ust.consumer.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ust.consumer.model.Room;

@Service
public class RoomServiceClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient client;
	
	@HystrixCommand(fallbackMethod = "getRoomsInfo_FallBack")
	public List<Room> getRoomsInfo(){
		
		InstanceInfo instance = client.getNextServerFromEureka("RoomServiceProducer", false);
		ResponseEntity<List<Room>> response = restTemplate.exchange("http://ROOMSERVICEPRODUCER/producer/roomProducer", 
																	HttpMethod.GET, null,
																	new ParameterizedTypeReference<List<Room>>() {
																	});
		System.out.println(instance.getAppName());
		System.out.println(instance.getHomePageUrl());
		return response.getBody();
	}
	
	@HystrixCommand(fallbackMethod = "getRoomInfo_FallBack")
	public List<Room> getRoomInfo(String roomNumber){
		
		InstanceInfo instance = client.getNextServerFromEureka("ROOMSERVICEPRODUCER", false);
		ResponseEntity<List<Room>> response = restTemplate.
				exchange("http://ROOMSERVICEPRODUCER/producer/roomProducer?roomNumber="+roomNumber, 
																	HttpMethod.GET, null,
																	new ParameterizedTypeReference<List<Room>>() {
																	});
		System.out.println(instance.getAppName());
		System.out.println(instance.getHomePageUrl());
		return response.getBody();
	}
	
	public List<Room> getRoomsInfo_FallBack(){
		List<Room> rml = new ArrayList<>();
		Room rm = new Room();
		rm.setId(1);
		rm.setName("default");
		rm.setRoomNumber("C0");
		rm.setBedInfo("This is a failed service");
		rml.add(rm);
		return rml;
	}
	
	public List<Room> getRoomInfo_FallBack(String roomNumber){
		List<Room> rml = new ArrayList<>();
		Room rm = new Room();
		rm.setId(1);
		rm.setName("default");
		rm.setRoomNumber("C0");
		rm.setBedInfo("This is a failed service");
		rml.add(rm);
		return rml;
	}
}
