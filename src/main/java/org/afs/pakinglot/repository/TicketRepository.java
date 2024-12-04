package org.afs.pakinglot.repository;

import org.afs.pakinglot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
