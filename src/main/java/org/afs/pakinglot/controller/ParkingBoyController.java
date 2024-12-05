package org.afs.pakinglot.controller;

import lombok.AllArgsConstructor;
import org.afs.pakinglot.dto.ParkRequestDto;
import org.afs.pakinglot.model.ParkingLot;
import org.afs.pakinglot.model.Ticket;
import org.afs.pakinglot.service.ParkingBoyService;
import org.afs.pakinglot.service.ParkingLotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/parkingBoys")
public class ParkingBoyController {
    private final ParkingBoyService parkingBoyService;

    @GetMapping
    public List<String> getAll() {
        return parkingBoyService.findAllString();
    }

    @PostMapping("/park")
    public Ticket park(@RequestBody ParkRequestDto parkRequestDto) {
        return parkingBoyService.park(parkRequestDto.getPlateNumber(), parkRequestDto.getStrategy());
    }
}
