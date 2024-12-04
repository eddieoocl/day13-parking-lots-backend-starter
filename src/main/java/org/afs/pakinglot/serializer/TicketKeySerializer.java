package org.afs.pakinglot.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.afs.pakinglot.model.Ticket;

import java.io.IOException;

public class TicketKeySerializer extends StdSerializer<Ticket> {

    public TicketKeySerializer() {
        this(null);
    }

    public TicketKeySerializer(Class<Ticket> t) {
        super(t);
    }

    @Override
    public void serialize(Ticket ticket, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeFieldName(ticket.getId().toString());
    }
}