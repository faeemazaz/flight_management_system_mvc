package com.flightbook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Passanger {
	@Id
	private Long passangerId;
	private String passangerName;
	private String passangerGender;
	private Integer passangerAge;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "passanger")
	private List<Booking> bookings;

	public Passanger(Long passangerId, String passangerName, String passangerGender, Integer passangerAge,
			List<Booking> bookings) {
		this.passangerId = passangerId;
		this.passangerName = passangerName;
		this.passangerGender = passangerGender;
		this.passangerAge = passangerAge;
		this.bookings = bookings;
	}

	public Passanger() {
		
	}

	public Long getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(Long passangerId) {
		this.passangerId = passangerId;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public String getPassangerGender() {
		return passangerGender;
	}

	public void setPassangerGender(String passangerGender) {
		this.passangerGender = passangerGender;
	}

	public Integer getPassangerAge() {
		return passangerAge;
	}

	public void setPassangerAge(Integer passangerAge) {
		this.passangerAge = passangerAge;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
