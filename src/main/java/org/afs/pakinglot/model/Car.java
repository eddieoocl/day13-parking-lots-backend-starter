package org.afs.pakinglot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private String plateNumber;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private ParkingLot parkingLot;

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}