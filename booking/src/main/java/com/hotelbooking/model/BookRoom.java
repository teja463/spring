package com.hotelbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="roombooking")
public class BookRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="HOTEL")
	private String hotel;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="ROOMS_BOOKED")
	private int roomsBooked;
	
	@Column(name="CHECKIN")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date checkIn;
	
	@Column(name="CHECKOUT")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date checkOut;
	
	@Column(name="TOTAL_COST")
	private Double totalCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(int roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "BookRoom [id=" + id + ", hotel=" + hotel + ", city=" + city + ", roomsBooked=" + roomsBooked
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", totalCost=" + totalCost + "]";
	}
	
	
}
