package com.immfly.filghtinfo.controller.resource.factory;

import com.immfly.filghtinfo.controller.resource.FlightResource;
import com.immfly.filghtinfo.model.Flight;

public class FlightResourceFactory {

    public static FlightResource fromModel(Flight flight) {
        FlightResource resource = new FlightResource();
        resource.setIdent(flight.getIdent());
        resource.setFaFlightID(flight.getFaFlightID());
        resource.setAirline(flight.getAirline());
        resource.setAirline_iata(flight.getAirline_iata());
        resource.setFlightnumber(flight.getFlightnumber());
        resource.setTailnumber(flight.getFlightnumber());
        resource.setType(flight.getType());
        resource.setCodeshares(flight.getCodeshares());
        resource.setBlocked(flight.getBlocked());
        resource.setDiverted(flight.getDiverted());
        resource.setCancelled(flight.getCancelled());
        resource.setOrigin(AirportResourceFactory.fromModel(flight.getOrigin()));
        resource.setDestination(AirportResourceFactory.fromModel(flight.getDestination()));
        return resource;
    }

}
