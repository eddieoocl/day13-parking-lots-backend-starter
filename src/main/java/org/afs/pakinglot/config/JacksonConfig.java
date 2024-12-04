package org.afs.pakinglot.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.afs.pakinglot.model.Ticket;
import org.afs.pakinglot.serializer.TicketKeyDeserializer;
import org.afs.pakinglot.serializer.TicketKeySerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addKeySerializer(Ticket.class, new TicketKeySerializer());
        module.addKeyDeserializer(Ticket.class, new TicketKeyDeserializer());
        mapper.registerModule(module);
        return mapper;
    }
}