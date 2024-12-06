package org.afs.pakinglot.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.afs.pakinglot.dto.FetchRequestDto;
import org.afs.pakinglot.dto.ParkRequestDto;
import org.afs.pakinglot.exception.CarNotFoundException;
import org.afs.pakinglot.model.Car;
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
    public Ticket park(@Valid @RequestBody ParkRequestDto parkRequestDto) {
        return parkingBoyService.park(parkRequestDto.getPlateNumber(), parkRequestDto.getStrategy());
    }

    @PostMapping("/fetch")
    public Car fetch(@Valid @RequestBody FetchRequestDto fetchRequestDto) throws CarNotFoundException {
        return parkingBoyService.fetch(fetchRequestDto.getPlateNumber());
    }
}
