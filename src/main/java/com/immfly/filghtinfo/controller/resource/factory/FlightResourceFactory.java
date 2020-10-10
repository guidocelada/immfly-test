package com.immfly.filghtinfo.controller.resource.factory;

import com.immfly.filghtinfo.controller.resource.FlightResource;
import com.immfly.filghtinfo.model.Flight;

public class FlightResourceFactory {

    public static FlightResource fromModel(Flight flight) {
        FlightResource resource = new FlightResource();
        resource.setIdent(flight.getIdent());
        return resource;//todo
    }
}
