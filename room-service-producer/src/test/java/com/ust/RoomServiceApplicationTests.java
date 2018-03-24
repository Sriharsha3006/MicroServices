package com.ust;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ust.producer.model.Room;
import com.ust.producer.repository.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceApplicationTests {
	
	@Autowired
	private RoomRepository repo;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testRepo() {
		Room room=repo.findByRoomNumber("P1");
		assertEquals("P1", room.getRoomNumber());
	}

}
