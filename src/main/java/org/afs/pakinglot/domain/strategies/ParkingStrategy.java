package org.afs.pakinglot.domain.strategies;


import org.afs.pakinglot.enums.ParkingStrategies;
import org.afs.pakinglot.model.ParkingLot;

import java.util.List;
import java.util.Map;

public interface ParkingStrategy {
    ParkingLot findParkingLot(List<ParkingLot> parkingLots);

    Map<ParkingStrategies, ParkingStrategy> parkingStrategyMap = Map.of(ParkingStrategies.Standard, new SequentiallyStrategy(),
            ParkingStrategies.Smart, new MaxAvailableStrategy(),
            ParkingStrategies.SuperSmart, new AvailableRateStrategy());

    static ParkingStrategy getParkingStrategy(final ParkingStrategies value) {
        return parkingStrategyMap.get(value);
    }
}
