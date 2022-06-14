package com.epam.training.repository.impl;

import com.epam.training.model.Category;
import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;
import com.epam.training.repository.TicketRepository;
import com.epam.training.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private Storage storage;

    @Override
    public Ticket bookTicket(Integer userId, Integer eventId, int place, Category category) {
        return storage.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return storage.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return storage.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(Integer ticketId) {
        return storage.cancelTicket(ticketId);
    }
}
