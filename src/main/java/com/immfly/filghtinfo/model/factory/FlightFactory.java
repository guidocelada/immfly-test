package com.immfly.filghtinfo.model.factory;

import com.immfly.filghtinfo.client.dto.AirplaneFlightDTO;
import com.immfly.filghtinfo.model.Flight;

public class FlightFactory {

    public static Flight fromDTO(AirplaneFlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setIdent(flightDTO.getIdent());
        return flight; //todo
    }
}
