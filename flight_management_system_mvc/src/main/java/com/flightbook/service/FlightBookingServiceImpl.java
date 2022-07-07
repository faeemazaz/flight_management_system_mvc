package com.flightbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbook.entity.Booking;
import com.flightbook.entity.Flight;
import com.flightbook.entity.Passanger;
import com.flightbook.repository.BookingRepo;
import com.flightbook.repository.FlightRepo;
import com.flightbook.repository.PassangerRepo;

@Service
public class FlightBookingServiceImpl implements FlightBookingService{
	
	@Autowired
	private FlightRepo flightRepo;
	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private PassangerRepo passangerRepo;

	@Override
	public Flight insertFlight(Flight flight) {
		return flightRepo.save(flight);
	}

	@Override
	public List<Flight> findAllFlights() {
		return flightRepo.findAll();
	}

	@Override
	public Booking insertBooking(Booking booking) {
		return bookingRepo.save(booking);
	}

	@Override
	public List<Booking> findAllBookings() {
		return bookingRepo.findAll();
	}

	@Override
	public Passanger insertPassangerBooking(Passanger passanger) {
		for(Booking bookings: passanger.getBookings())
		{
			bookings.setPassanger(passanger);
		}
		return passangerRepo.save(passanger);
	}

	@Override
	public List<Passanger> getPassangerBooking() {
		return passangerRepo.findAll();
	}

	@Override
	public Passanger insertPassanger(Passanger passanger) {
		return passangerRepo.save(passanger);
	}

}
