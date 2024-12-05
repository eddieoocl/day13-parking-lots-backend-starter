package org.afs.pakinglot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.afs.pakinglot.enums.ParkingStrategies;

@Getter
@Setter
public class ParkRequestDto {
    @NotNull
    private ParkingStrategies strategy;

    @NotNull
    private String plateNumber;
}

