package com.ust.producer.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.producer.model.Room;

@Transactional
@Repository
public interface RoomRepository extends CrudRepository<Room, Integer>{
	
	public Room findByRoomNumber(String roomNumber);
	
	
	@Modifying(clearAutomatically = true)
	@Query("Update com.ust.producer.model.Room r set r.availability=:notAvailable where r.roomNumber=:roomNumber")
	public int bookARoom(@Param("roomNumber") String roomNumber, @Param("notAvailable") String notAvailable);
	
}
