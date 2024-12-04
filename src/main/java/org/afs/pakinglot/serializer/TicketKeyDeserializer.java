package org.afs.pakinglot.serializer;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import org.afs.pakinglot.model.Ticket;

import java.io.IOException;

public class TicketKeyDeserializer extends KeyDeserializer {

    @Override
    public Ticket deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        Ticket ticket = new Ticket();
        ticket.setId(Integer.parseInt(key));
        return ticket;
    }
}