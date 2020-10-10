package com.immfly.filghtinfo.controller.resource.factory;

import com.immfly.filghtinfo.controller.resource.AirportResource;
import com.immfly.filghtinfo.model.Airport;

public class AirportResourceFactory {

    public static AirportResource fromModel(Airport airport) {
        AirportResource resource = new AirportResource();
        resource.setAirport_name(airport.getAirport_name());
        resource.setAirport_name(airport.getCity());
        resource.setAirport_name(airport.getCode());
        resource.setAirport_name(airport.getAlternate_ident());
        return resource;
    }
}
