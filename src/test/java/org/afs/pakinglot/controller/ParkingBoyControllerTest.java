package org.afs.pakinglot.controller;

import org.afs.pakinglot.domain.strategies.ParkingStrategy;
import org.afs.pakinglot.model.ParkingLot;
import org.afs.pakinglot.model.Ticket;
import org.afs.pakinglot.repository.CarRepository;
import org.afs.pakinglot.repository.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ParkingBoyControllerTest {
    @Autowired
    private MockMvc client;

    @Autowired
    private ParkingLotRepository parkingBoyRepository;

    @Autowired
    private JacksonTester<Ticket> ticketJacksonTester;


    @BeforeEach
    void setUp() {
        parkingBoyRepository.deleteAll();
        parkingBoyRepository.flush();

        ParkingLot parkingLot1 = new ParkingLot("The Plaza Park", 9);
        ParkingLot parkingLot2 = new ParkingLot("City Mall Garage", 12);
        ParkingLot parkingLot3 = new ParkingLot("Office Tower Parking", 9);
        parkingBoyRepository.saveAll(Arrays.asList(parkingLot1, parkingLot2, parkingLot3));
    }

    @Test
    void should_return_list_of_parking_strategy_when_get_all_given_strategy_exists() throws Exception {
        // When
        client.perform(get("/parkingBoys"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    void should_return_ticket_when_park_given_plate_number_and_strategy() throws Exception {
        // Given
        String requestBody = """
                 {
                    "plateNumber": "AB-1234",
                    "strategy": "SuperSmart"
                 }\
                """;

        // When
        final MvcResult result = client.perform(post("/parkingBoys/park")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        final Ticket fetchedTicket = ticketJacksonTester.parseObject(result.getResponse().getContentAsString());
        assertThat(fetchedTicket.getCar().getPlateNumber()).isEqualTo("AB-1234");
    }
}