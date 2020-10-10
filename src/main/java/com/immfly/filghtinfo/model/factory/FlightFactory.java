package com.immfly.filghtinfo.model.factory;

import com.immfly.filghtinfo.client.dto.FlightDTO;
import com.immfly.filghtinfo.model.Flight;

public class FlightFactory {

    public static Flight fromDTO(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setIdent(flightDTO.getIdent());
        flight.setFaFlightID(flightDTO.getFaFlightID());
        flight.setAirline(flightDTO.getAirline());
        flight.setAirline_iata(flightDTO.getAirline_iata());
        flight.setFlightnumber(flightDTO.getFlightnumber());
        flight.setTailnumber(flightDTO.getFlightnumber());
        flight.setType(flightDTO.getType());
        flight.setCodeshares(flightDTO.getCodeshares());
        flight.setBlocked(flightDTO.getBlocked());
        flight.setDiverted(flightDTO.getDiverted());
        flight.setCancelled(flightDTO.getCancelled());
        flight.setOrigin(AirportFactory.fromDTO(flightDTO.getOrigin()));
        flight.setDestination(AirportFactory.fromDTO(flightDTO.getDestination()));
        return flight;
    }
}
