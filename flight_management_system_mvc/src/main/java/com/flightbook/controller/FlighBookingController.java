package com.flightbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightbook.entity.Booking;
import com.flightbook.entity.Flight;
import com.flightbook.entity.Passanger;
import com.flightbook.service.FlightBookingService;

@Controller
public class FlighBookingController {
	@Autowired
	private FlightBookingService flightBookingService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fetchFlights(Model mdl) {
		List<Flight> getFlights = flightBookingService.findAllFlights();
		mdl.addAttribute("title", "View Flights");
		mdl.addAttribute("flights", getFlights);
		return "showflight";
	}

	@RequestMapping(value = "/addFlight", method = RequestMethod.GET)
	public String goToAddFlight(Model mdl) {
		mdl.addAttribute("flight", new Flight());
		return "addflight";
	}

	@RequestMapping(value = "/flight", method = RequestMethod.POST)
	public String insertFlight(@ModelAttribute Flight flight) {
		flightBookingService.insertFlight(flight);
		return "redirect:/";
	}

	@RequestMapping(value = "/viewPassenger", method = RequestMethod.GET)
	public String goToShowPassanger(Model mdl) {
		List<Passanger> getPassengers = flightBookingService.getPassangerBooking();
		mdl.addAttribute("passangers", getPassengers);
		return "showpassenger";
	}
	
	@RequestMapping(value = "/addPassenger", method = RequestMethod.GET)
	public String goToAddPassanger(Model mdl) {
		mdl.addAttribute("passanger", new Passanger());
		return "addpassenger";
	}

	@RequestMapping(value = "/passenger", method = RequestMethod.POST)
	public String insertPassanger(@ModelAttribute Passanger passanger) {
		flightBookingService.insertPassanger(passanger);
		return "redirect:/viewPassenger";
	}

	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public String fetchBooking(Model mdl) {
		List<Booking> getBookings = flightBookingService.findAllBookings();
		mdl.addAttribute("bookings", getBookings);
		return "showbookingpassenger";
	}

	@RequestMapping(value = "/addPassengerBooking", method = RequestMethod.GET)
	public String goToAddPassangerBooking(Model mdl) {
		List<Passanger> getPassanger = flightBookingService.getPassangerBooking();
		mdl.addAttribute("passangers", getPassanger);
		mdl.addAttribute("booking", new Booking());
		return "addbookingpassenger";
	}

	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String insertBooking(@ModelAttribute Booking booking) {
		flightBookingService.insertBooking(booking);
		return "redirect:/bookings";
	}
}
