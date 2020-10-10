package com.immfly.filghtinfo.client;

import com.immfly.filghtinfo.client.dto.FlightDTO;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AirplaneFlightsClientTest {

    public static MockWebServer mockBackEnd;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @Test
    public void getTest() throws IOException {

        // Set up mock server
        String mockResponseJson = new String(new ClassPathResource("mock-response.json").getInputStream().readAllBytes());
        mockBackEnd.enqueue(
                new MockResponse()
                        .setBody(mockResponseJson)
                        .addHeader("Content-Type", "application/json")
        );

        // Set up client
        AirplaneFlightsClient client = new AirplaneFlightsClient();
        ReflectionTestUtils.setField(client, "baseUrl", "http://localhost:" + mockBackEnd.getPort());
        ReflectionTestUtils.setField(client, "timeout", Duration.ofSeconds(100));
        client.init();

        // Test
        String tailNumber = "EC-MYT";
        List<FlightDTO> flights = client.get(tailNumber);

        assertThat(flights).isNotNull();
        assertThat(flights).isNotEmpty();
        assertThat(flights.stream().findFirst().get()).isNotNull();
        assertThat(flights.stream().findFirst().get()).extracting(FlightDTO::getTailnumber).isEqualTo(tailNumber);
    }
}
