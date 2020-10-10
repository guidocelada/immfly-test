package com.immfly.filghtinfo.model.factory;

import com.immfly.filghtinfo.client.dto.AirportDTO;
import com.immfly.filghtinfo.model.Airport;

public class AirportFactory {

    public static Airport fromDTO(AirportDTO dto) {
        Airport airport = new Airport();
        airport.setAirport_name(dto.getAirport_name());
        airport.setAirport_name(dto.getCity());
        airport.setAirport_name(dto.getCode());
        airport.setAirport_name(dto.getAlternate_ident());
        return airport;
    }
}
