package com.ust.producer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room{
	
	@Id
	@Column(name="ROOM_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ROOM_NUMBER")
	private String roomNumber;
	
	@Column(name="BED_INFO")
	private String bedInfo;
	
	@Column(name="NUM_PPL")
	private Integer numPpl;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="AVAILABILITY")
	private String availability;
	

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public String getBedInfo() {
		return bedInfo;
	}
	
	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
	
	
	public Integer getNumPpl() {
		return numPpl;
	}
	
	public void setNumPpl(Integer numPpl) {
			this.numPpl = numPpl;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	
}
