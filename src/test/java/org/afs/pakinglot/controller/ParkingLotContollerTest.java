package org.afs.pakinglot.controller;

import org.afs.pakinglot.model.ParkingLot;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ParkingLotControllerTest {
    @Autowired
    private MockMvc client;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private JacksonTester<ParkingLot> parkingLotJacksonTester;

    @Autowired
    private JacksonTester<List<ParkingLot>> parkingLotsJacksonTester;

    @BeforeEach
    void setUp() {
        parkingLotRepository.deleteAll();
        parkingLotRepository.flush();
        ParkingLot parkingLot1 = new ParkingLot("The Plaza Park", 9);
        ParkingLot parkingLot2 = new ParkingLot("City Mall Garage", 12);
        ParkingLot parkingLot3 = new ParkingLot("Office Tower Parking", 9);
        parkingLotRepository.saveAll(Arrays.asList(parkingLot1, parkingLot2, parkingLot3));
    }

    @Test
    void should_return_list_of_parking_lots_when_get_all_given_parking_lots_exist() throws Exception {
        // Given
        final List<ParkingLot> givenParkingLots = parkingLotRepository.findAll();

        // When
        final MvcResult result = client.perform(get("/parkinglots"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Then
        final List<ParkingLot> fetchedParkingLots = parkingLotsJacksonTester.parseObject(result.getResponse().getContentAsString());
        assertThat(fetchedParkingLots).hasSameSizeAs(givenParkingLots);
        assertThat(fetchedParkingLots)
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(givenParkingLots);
    }
}