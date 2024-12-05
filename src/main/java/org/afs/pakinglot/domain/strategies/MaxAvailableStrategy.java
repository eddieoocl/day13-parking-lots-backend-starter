package org.afs.pakinglot.domain.strategies;


import org.afs.pakinglot.enums.ParkingStrategies;
import org.afs.pakinglot.model.ParkingLot;

import java.util.Comparator;
import java.util.List;

public class MaxAvailableStrategy implements ParkingStrategy{
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .max(Comparator.comparingInt(ParkingLot::getAvailableCapacity))
                .orElseThrow();
    }

    @Override
    public String toString() {
        return ParkingStrategies.Smart.toString();
    }
}
