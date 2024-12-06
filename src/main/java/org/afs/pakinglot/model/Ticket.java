package org.afs.pakinglot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
    private Car car;

    private Integer position;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    @JsonIgnore
    private ParkingLot parkingLot;

    public Ticket(String plateNumber, int position, ParkingLot parkingLot) {
        this.car = new Car(plateNumber);
        this.position = position;
        this.parkingLot = parkingLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(car.getPlateNumber(), ticket.car.getPlateNumber());
    }
}
