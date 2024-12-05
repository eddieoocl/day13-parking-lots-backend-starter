package org.afs.pakinglot.enums;

import org.afs.pakinglot.domain.strategies.AvailableRateStrategy;
import org.afs.pakinglot.domain.strategies.MaxAvailableStrategy;
import org.afs.pakinglot.domain.strategies.ParkingStrategy;
import org.afs.pakinglot.domain.strategies.SequentiallyStrategy;

import java.util.Map;

public enum ParkingStrategies {
    Standard,
    Smart,
    SuperSmart
}
