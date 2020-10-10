package com.immfly.filghtinfo.service;

import com.immfly.filghtinfo.client.AirplaneFlightsClient;
import com.immfly.filghtinfo.client.dto.FlightDTO;
import com.immfly.filghtinfo.exception.AirplaneNotFoundException;
import com.immfly.filghtinfo.exception.FlightNotFoundException;
import com.immfly.filghtinfo.model.Flight;
import com.immfly.filghtinfo.model.factory.FlightFactory;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final AirplaneFlightsClient client;

    public FlightService(AirplaneFlightsClient client) {
        this.client = client;
    }

    public Flight getFlight(String tailNumber, String flightNumber)
            throws AirplaneNotFoundException, FlightNotFoundException {

        FlightDTO flightDTO = client.get(tailNumber).stream()
                .filter(airplaneInfo -> airplaneInfo.getFlightnumber().equals(flightNumber))
                .findFirst()
                .orElseThrow(() -> new FlightNotFoundException(flightNumber));

        return FlightFactory.fromDTO(flightDTO);
    }
}
