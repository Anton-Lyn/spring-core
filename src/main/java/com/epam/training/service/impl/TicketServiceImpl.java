package com.epam.training.service.impl;

import com.epam.training.model.Category;
import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;
import com.epam.training.repository.TicketRepository;
import com.epam.training.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket bookTicket(Integer userId, Integer eventId, int place, Category category) {
        return ticketRepository.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketRepository.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketRepository.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(Integer ticketId) {
        return ticketRepository.cancelTicket(ticketId);
    }

}
