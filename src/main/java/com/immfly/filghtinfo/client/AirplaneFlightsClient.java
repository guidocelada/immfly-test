package com.immfly.filghtinfo.client;

import com.immfly.filghtinfo.client.dto.FlightDTO;
import com.immfly.filghtinfo.config.WebClientBuilderFactory;
import com.immfly.filghtinfo.exception.AirplaneNotFoundException;
import com.immfly.filghtinfo.exception.ExternalTimeoutException;
import io.netty.handler.timeout.TimeoutException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Component
public class AirplaneFlightsClient {

    @Value("${client.airplane-flights.base-url}")
    private String baseUrl;

    @Value("${client.airplane-flights.timeout:1s}")
    private Duration timeout;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = WebClientBuilderFactory.generate(baseUrl, timeout)
                .build();
    }

    @Cacheable(value = "FLIGHTS_BY_TAIL", key = "'FBT_' + #tailNumber")
    public List<FlightDTO> get(String tailNumber) throws AirplaneNotFoundException {
        try {
            FlightDTO[] response = webClient
                    .get()
                    .uri("/v1/flight-information-tail/" + tailNumber)
                    .retrieve()
                    .onStatus(status -> status.equals(HttpStatus.NOT_FOUND), clientResponse -> {
                        throw new AirplaneNotFoundException(tailNumber);
                    })
                    .onStatus(HttpStatus::isError, clientResponse -> {
                        throw new RuntimeException("There was a problem getting the airplane flights by tail number. (Error " + clientResponse.statusCode().value() + ")");
                    })
                    .bodyToMono(FlightDTO[].class)
                    .timeout(timeout)
                    .block();

            if (response == null) {
                throw new RuntimeException("There was an unexpected error getting the airplane flights by tail number.");
            }

            return Arrays.asList(response);

        } catch (Exception ex) {
            if (ex instanceof TimeoutException ||
                    ex.getCause() instanceof TimeoutException ||
                    ex.getCause() instanceof java.util.concurrent.TimeoutException) {
                throw new ExternalTimeoutException(ex);
            }
            throw ex;
        }
    }
}
