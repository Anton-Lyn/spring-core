package com.epam.training.storage.impl;

import com.epam.training.model.Category;
import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;
import com.epam.training.storage.Storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageImpl implements Storage {

    private final Map<Integer, User> userStorage;
    private final Map<Integer, Ticket> ticketStorage;
    private final Map<Integer, Event> eventStorage;

    public StorageImpl() {
        this.userStorage = new HashMap<>();
        this.ticketStorage = new HashMap<>();
        this.eventStorage = new HashMap<>();
    }

    @Override
    public User getUserById(Integer userId) {
        return userStorage.get(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : userStorage.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new RuntimeException("User not found!!!");
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> users = new ArrayList<>();
        for (User user : userStorage.values()) {
            if (user.getName().equals(name)) {
                users.add(user);
            }
        }

        return users;
    }

    @Override
    public User createUser(User user) {
        return userStorage.put(user.getId(), user);
    }

    @Override
    public User updateUser(User user) {
        return userStorage.put(user.getId(), user);
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return userStorage.values().removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public Ticket bookTicket(Integer userId, Integer eventId, int place, Category category) {
        for (Ticket ticket : ticketStorage.values()) {
            if (ticket.getPlace() == place) {
                checkPlaceAvailability(eventId, ticket);
                ticket.setUserId(userId);
                ticket.setCategory(category);
                return ticketStorage.put(ticket.getId(), ticket);
            }
        }

        throw new RuntimeException("Wrong place!");
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : ticketStorage.values()) {
            if (ticket.getUserId().equals(user.getId())) {
                tickets.add(ticket);
            }
        }

        return tickets;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : ticketStorage.values()) {
            if (ticket.getEventId().equals(event.getId()) && ticket.getUserId() != null) {
                tickets.add(ticket);
            }
        }

        return tickets;
    }

    @Override
    public boolean cancelTicket(Integer ticketId) {
        if (ticketStorage.containsKey(ticketId)) {
            Ticket ticket = ticketStorage.get(ticketId);
            ticket.setUserId(null);
            ticket.setCategory(null);
            ticketStorage.put(ticketId, ticket);
            return true;
        }

        throw new RuntimeException("Can't find ticket!");
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventStorage.get(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> events = new ArrayList<>();
        for (Event event : eventStorage.values()) {
            if (event.getTitle().equals(title)) {
                events.add(event);
            }
        }

        return events;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> events = new ArrayList<>();
        for (Event event : eventStorage.values()) {
            if (event.getDate().compareTo(day) == 0) {
                events.add(event);
            }
        }

        return events;
    }

    @Override
    public Event createEvent(Event event) {
        return eventStorage.put(event.getId(), event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventStorage.put(event.getId(), event);
    }

    @Override
    public boolean deleteEvent(Integer eventId) {
        return eventStorage.values().removeIf(event -> event.getId().equals(eventId));
    }

    private void checkPlaceAvailability(Integer eventId, Ticket ticket) {
        checkEvent(eventId, ticket);
        checkBooking(ticket);
    }

    private void checkBooking(Ticket ticket) {
        if (ticket.getUserId() != null) {
            throw new RuntimeException("Place already booked!");
        }
    }

    private void checkEvent(Integer eventId, Ticket ticket) {
        if (!eventStorage.containsKey(eventId)) {
            throw new RuntimeException("Wrong doesn't exist!");
        }
    }

}
