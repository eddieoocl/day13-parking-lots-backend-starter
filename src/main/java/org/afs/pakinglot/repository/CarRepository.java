package org.afs.pakinglot.repository;

import org.afs.pakinglot.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
