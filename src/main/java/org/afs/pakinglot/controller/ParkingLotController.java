package org.afs.pakinglot.controller;

import lombok.AllArgsConstructor;
import org.afs.pakinglot.model.ParkingLot;
import org.afs.pakinglot.service.ParkingLotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/parkingLots")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> getAll() {
        return parkingLotService.findAll();
    }
}
