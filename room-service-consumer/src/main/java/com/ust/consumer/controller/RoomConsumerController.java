package com.ust.consumer.controller;

import com.netflix.discovery.EurekaClient;
import com.ust.consumer.client.RoomServiceClient;
import com.ust.consumer.model.Room;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/consumer")
public class RoomConsumerController {
	
	@Autowired
	private RoomServiceClient roomServiceClient;
	
	/*@Autowired
	private RoomServiceWithFeign roomServiceWithFeign;*/
	
	@Value("${welcome.message}")
	private String message;
	
	@Autowired
	EurekaClient client;
	
	@RequestMapping(value="/roomConsumer", method=RequestMethod.GET)
	public List<Room> getAllRooms(@RequestParam(name="roomNumber", required=false)String roomNumber){
		System.out.println(message);
		if(StringUtils.isNotEmpty(roomNumber)) {
			return roomServiceClient.getRoomInfo(roomNumber);
		}
		return roomServiceClient.getRoomsInfo();
	}
	
	/*@RequestMapping(value="/getRoomsWithFeign", method=RequestMethod.GET)
	public List<Room> getAllRoomsWithFeign(){
		return roomServiceWithFeign.findAll(null);
	}*/
}
