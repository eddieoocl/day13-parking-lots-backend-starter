package org.afs.pakinglot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    private Integer id;

    @OneToOne
    private Car car;

    private Integer position;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    public Ticket(String plateNumber, int position, ParkingLot parkingLot) {
        this.car = new Car(plateNumber);
        this.position = position;
        this.parkingLot = parkingLot;
    }
}
