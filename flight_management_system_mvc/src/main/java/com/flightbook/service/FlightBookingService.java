package com.flightbook.service;

import java.util.List;

import com.flightbook.entity.Booking;
import com.flightbook.entity.Flight;
import com.flightbook.entity.Passanger;

public interface FlightBookingService {
	Flight insertFlight(Flight flight);
	List<Flight> findAllFlights();
	
	Booking insertBooking(Booking booking);
	List<Booking> findAllBookings();
	
	Passanger insertPassangerBooking(Passanger passanger);
	List<Passanger> getPassangerBooking();
	Passanger insertPassanger(Passanger passanger);
}
