package com.immfly.filghtinfo.controller;

import com.immfly.filghtinfo.controller.resource.FlightResource;
import com.immfly.filghtinfo.controller.resource.factory.FlightResourceFactory;
import com.immfly.filghtinfo.model.Flight;
import com.immfly.filghtinfo.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.SpringDocUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@Validated
@Tag(name = "Flight Information API")
public class FlightController {

    static {
        SpringDocUtils.getConfig().addRestControllers(FlightController.class);
    }

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = {"/v1/flight-information/{tail-number}/{flight-number}"})
    @Operation(summary = "Gets the flight information for the given tail number and flight number")
    public FlightResource get(@PathVariable("tail-number") @NotEmpty @Parameter(example = "EC-MYT")
                                      String tailNumber,
                              @PathVariable("flight-number") @NotEmpty @Parameter(example = "653")
                                      String flightNumber) {

        Flight flight = flightService.getFlight(tailNumber, flightNumber);

        return FlightResourceFactory.fromModel(flight);
    }
}
