package org.afs.pakinglot.service;

import lombok.AllArgsConstructor;
import org.afs.pakinglot.model.ParkingLot;
import org.afs.pakinglot.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingLotService {
    private final ParkingLotRepository parkingBoyRepository;

    public List<ParkingLot> findAll() {
        return parkingBoyRepository.findAll();
    }
}
