package org.afs.pakinglot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.afs.pakinglot.domain.exception.NoAvailablePositionException;
import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private final int capacity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Ticket> tickets = new ArrayList<>();

    private static final int DEFAULT_CAPACITY = 10;

    public ParkingLot() {
        this(DEFAULT_CAPACITY);
    }

    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    @JsonIgnore
    public int getAvailableCapacity() {
        return capacity - tickets.size();
    }

    public Ticket park(Car car) {
        if (isFull()) {
            throw new NoAvailablePositionException();
        }

        Ticket ticket = new Ticket(car.getPlateNumber(), tickets.size() + 1, this);
        tickets.add(ticket);
        return ticket;
    }

    @JsonIgnore
    public boolean isFull() {
        return capacity == tickets.size();
    }

    public Car fetch(Ticket ticket) {
        int index = tickets.indexOf(ticket);
        if (index == -1) {
            throw new UnrecognizedTicketException();
        }

        Ticket removedTicket = tickets.remove(index);
        return removedTicket.getCar();
    }

    public boolean contains(Ticket ticket) {
        return tickets.contains(ticket);
    }

    @JsonIgnore
    public double getAvailablePositionRate() {
        return getAvailableCapacity() / (double) capacity;
    }
}