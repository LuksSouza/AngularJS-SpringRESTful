package com.airplanescompany.flights.populatedatabase;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.airplanescompany.flights.domain.Airplane;
import com.airplanescompany.flights.domain.Flight;
import com.airplanescompany.flights.domain.Pilot;
import com.airplanescompany.flights.repository.AirplanesRepository;
import com.airplanescompany.flights.repository.FlightRepository;
import com.airplanescompany.flights.repository.PilotRepository;
import com.airplanescompany.flights.services.AirplaneServices;
import com.airplanescompany.flights.services.FlightServices;
import com.airplanescompany.flights.services.PilotServices;

public class PopulateDatabase {

	public static void main(String[] args) {
		Airplane airplane = new Airplane();
		airplane.setId(1l);
		airplane.setModel("F190");
		airplane.setName("AirForce");
		
		Pilot pilot = new Pilot();
		pilot.setId(1l);
		pilot.setName("John");
		pilot.setAge(38);
		
		Flight flight = new Flight();
		flight.setId(1l);
		flight.setPilot(pilot);
		flight.setAirplane(airplane);
		flight.setHometown("Sao Paulo-Brazil");
		flight.setDestinationCity("Sydnei-Australia");
		flight.setDepartureTime(new Date(1900+115, 5, 10));
		flight.setArrivalTime(new Date(1900+115, 5, 11));

		AirplaneServices airplaneServices = new AirplaneServices();
		PilotServices pilotServices = new PilotServices();
		FlightServices flightServices = new FlightServices();
		
		airplaneServices.save(airplane);
		pilotServices.save(pilot);
		flightServices.save(flight);
	}
}
