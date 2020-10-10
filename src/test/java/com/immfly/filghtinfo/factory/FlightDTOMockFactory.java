package com.immfly.filghtinfo.factory;

import com.immfly.filghtinfo.client.dto.FlightDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightDTOMockFactory {

    public static List<FlightDTO> generate() {
        return Stream.of(ECMYT653(), ACMYA853()).collect(Collectors.toList());
    }

    public static FlightDTO ECMYT653() {
        FlightDTO flight = new FlightDTO();
        flight.setIdent("IBB653");
        flight.setFaFlightID("IBB653-1581399936-airline-0136");
        flight.setAirline("IBB");
        flight.setAirlineIata("NT");
        flight.setFlightnumber("653");
        flight.setTailnumber("EC-MYT");
        flight.setType("Form_Airline");
        flight.setCodeshares("IBE123");
        flight.setBlocked(false);
        flight.setDiverted(false);
        flight.setCancelled(false);
        flight.setOrigin(AirportDTOMockFactory.tenerife());
        flight.setDestination(AirportDTOMockFactory.laGomera());
        return flight;
    }

    public static FlightDTO ACMYA853() {
        FlightDTO flight = new FlightDTO();
        flight.setIdent("IBB853");
        flight.setFaFlightID("IBB853-1581399936-airline-0136");
        flight.setAirline("IBB");
        flight.setAirlineIata("NT");
        flight.setFlightnumber("853");
        flight.setTailnumber("AC-MYA");
        flight.setType("Form_Airline");
        flight.setCodeshares("IBE123");
        flight.setBlocked(false);
        flight.setDiverted(false);
        flight.setCancelled(false);
        flight.setOrigin(AirportDTOMockFactory.tenerife());
        flight.setDestination(AirportDTOMockFactory.laGomera());
        return flight;
    }
}
