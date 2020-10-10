package com.immfly.filghtinfo.service;

import com.immfly.filghtinfo.client.AirplaneFlightsClient;
import com.immfly.filghtinfo.client.dto.FlightDTO;
import com.immfly.filghtinfo.factory.FlightDTOMockFactory;
import com.immfly.filghtinfo.model.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private AirplaneFlightsClient client;

    @InjectMocks
    private FlightService service;

    @Test
    public void getFlightTest() {

        List<FlightDTO> flights = FlightDTOMockFactory.generate();

        FlightDTO flight = flights.stream().findAny().orElseThrow(() -> new RuntimeException("No Flight generated on Mock Factory"));

        String tailNumber = flight.getTailnumber();
        String flightNumber = flight.getFlightnumber();

        Mockito
                .when(client.get(tailNumber))
                .thenReturn(flights);

        Flight resultingFlight = service.getFlight(tailNumber, flightNumber);

        assertThat(resultingFlight).isNotNull();
        assertThat(resultingFlight).extracting(Flight::getTailnumber).isEqualTo(tailNumber);
        assertThat(resultingFlight).extracting(Flight::getFlightnumber).isEqualTo(flightNumber);
    }
}
