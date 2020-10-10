package com.immfly.filghtinfo.factory;

import com.immfly.filghtinfo.client.dto.AirportDTO;

public class AirportDTOMockFactory {

    public static AirportDTO tenerife() {
        AirportDTO airport = new AirportDTO();
        airport.setCity("Tenerife");
        airport.setCode("GCXO");
        airport.setAlternateIdent("TFN");
        airport.setAirportName("TenerifeNorth(LosRodeos)");
        return airport;
    }
    public static AirportDTO laGomera() {
        AirportDTO airport = new AirportDTO();
        airport.setCity("LaGomera");
        airport.setCode("GCGM");
        airport.setAlternateIdent("GMZ");
        airport.setAirportName("LaGomera");
        return airport;
    }
}
