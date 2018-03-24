package com.ust.producer.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ust.producer.model.Room;
import com.ust.producer.repository.RoomRepository;

@RestController
@RequestMapping(value="/producer")
public class RoomController {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	private EurekaClient client;
	
	@RequestMapping(value="/roomProducer",method=RequestMethod.GET)
	public List<Room> findAll(@RequestParam(name="roomNumber", required=false)String roomNumber){
		if(StringUtils.isNotEmpty(roomNumber)) {
			return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
		}
		InstanceInfo instance = this.client.getNextServerFromEureka("RoomServiceProducer", false);
		
		System.out.println(instance.getAppName());
		System.out.println(instance.getHomePageUrl());
		
		return (List<Room>) roomRepository.findAll();
	}
	
	@RequestMapping(value="/bookARoom/{roomNumber}", method=RequestMethod.PUT)
	public int bookARoom(@RequestBody Room room,@PathVariable("roomNumber") String roomNumber){
		System.out.println(room.getId());
		return roomRepository.bookARoom(roomNumber, room.getAvailability());
	}
}
