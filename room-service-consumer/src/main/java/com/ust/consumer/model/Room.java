package com.ust.consumer.model;

public class Room {
	
	private long id;
	private String name;
	private String roomNumber;
	private Integer numPpl;
	private String bedInfo;
	private double price;
	private String availability;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Integer getNumPpl() {
		return numPpl;
	}
	public void setNumPpl(Integer numPpl) {
		this.numPpl = numPpl;
	}
	
	
	
}
