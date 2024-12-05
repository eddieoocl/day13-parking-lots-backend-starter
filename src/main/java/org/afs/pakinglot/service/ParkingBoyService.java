package org.afs.pakinglot.service;

import lombok.AllArgsConstructor;
import org.afs.pakinglot.domain.ParkingBoy;
import org.afs.pakinglot.domain.strategies.AvailableRateStrategy;
import org.afs.pakinglot.domain.strategies.MaxAvailableStrategy;
import org.afs.pakinglot.domain.strategies.ParkingStrategy;
import org.afs.pakinglot.domain.strategies.SequentiallyStrategy;
import org.afs.pakinglot.dto.ParkRequestDto;
import org.afs.pakinglot.enums.ParkingStrategies;
import org.afs.pakinglot.model.Car;
import org.afs.pakinglot.model.Ticket;
import org.afs.pakinglot.repository.CarRepository;
import org.afs.pakinglot.repository.ParkingLotRepository;
import org.afs.pakinglot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingBoyService {
    private ParkingLotRepository parkingLotRepository;

    private CarRepository carRepository;

    private TicketRepository ticketRepository;

    public List<String> findAllString() {
        return Arrays.stream(ParkingStrategies.values()).map(Object::toString).toList();
    }

    public Ticket park(String plateNumber, ParkingStrategies parkingStrategy) {
        ParkingStrategy strategy = ParkingStrategy.getParkingStrategy(parkingStrategy);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotRepository.findAll(), strategy);

        Car car = findCar(plateNumber);
        Ticket ticket = parkingBoy.park(car);

        Ticket savedTicket = ticketRepository.save(ticket);

        car.setTicket(savedTicket);

        return savedTicket;
    }

    private Car findCar(String plateNumber) {
        Optional<Car> car = carRepository.findById(plateNumber);

        if (car.isPresent()) {
            return car.get();
        }

        Car newCar = new Car(plateNumber);
        return carRepository.save(newCar);
    }
}
