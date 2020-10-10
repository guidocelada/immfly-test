package com.immfly.filghtinfo.controller.resource.factory;

import com.immfly.filghtinfo.controller.resource.AirportResource;
import com.immfly.filghtinfo.model.Airport;

public class AirportResourceFactory {

    public static AirportResource fromModel(Airport airport) {
        AirportResource resource = new AirportResource();
        resource.setAirportName(airport.getAirportName());
        resource.setAirportName(airport.getCity());
        resource.setAirportName(airport.getCode());
        resource.setAirportName(airport.getAlternateIdent());
        return resource;
    }
}
