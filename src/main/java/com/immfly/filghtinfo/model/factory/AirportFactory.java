package com.immfly.filghtinfo.model.factory;

import com.immfly.filghtinfo.client.dto.AirportDTO;
import com.immfly.filghtinfo.model.Airport;

public class AirportFactory {

    public static Airport fromDTO(AirportDTO dto) {
        Airport airport = new Airport();
        airport.setAirportName(dto.getAirportName());
        airport.setAirportName(dto.getCity());
        airport.setAirportName(dto.getCode());
        airport.setAirportName(dto.getAlternateIdent());
        return airport;
    }
}
