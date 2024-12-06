package org.afs.pakinglot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FetchRequestDto {
    @NotNull
    private String plateNumber;
}
