package org.afs.pakinglot.repository;

import org.afs.pakinglot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t FROM Ticket t WHERE t.car.plateNumber = :plateNumber")
    Ticket findByCarPlateNumber(@Param("plateNumber") String plateNumber);
}
