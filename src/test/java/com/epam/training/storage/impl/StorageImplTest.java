package com.epam.training.storage.impl;

import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.training.model.Category.STANDARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StorageImplTest {

    private StorageImpl underTest;

    private User user1;

    private Event event1;
    private Event event2;

    private final Date date = new Date();

    @BeforeEach
    void setUp() {
        underTest = new StorageImpl();

        Map<Integer, User> userStorage = new HashMap<>();
        Map<Integer, Ticket> ticketStorage = new HashMap<>();
        Map<Integer, Event> eventStorage = new HashMap<>();

        user1 = new User(1, "Hulio", "hulio@gmail.com");

        event1 = new Event(1, "Avengers", date);
        event2 = new Event(2, "Spider-Man", date);

        userStorage.put(1, user1);

        ticketStorage.put(1, new Ticket(1, 1, null, null, 101));
        ticketStorage.put(2, new Ticket(2, 2, null, null, 101));
        ticketStorage.put(3, new Ticket(3, 1, null, null, 102));

        eventStorage.put(1, event1);
        eventStorage.put(2, event2);

        underTest.setTicketStorage(ticketStorage);
        underTest.setEventStorage(eventStorage);
        underTest.setUserStorage(userStorage);
    }

    @Test
    void getUserById() {
        assertEquals(underTest.getUserById(1), user1);
    }

    @Test
    void getUserByEmail() {
        assertEquals(underTest.getUserByEmail("hulio@gmail.com"), user1);
    }

    @Test
    void getUsersByName() {
        List<User> expected = List.of(user1);
        List<User> actual = underTest.getUsersByName("Hulio", 1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void createUser() {
        User expected = new User(3, "Antonio", "antonio@gmail.com");
        User actual = underTest.createUser(expected);

        assertEquals(expected, actual);
    }

    @Test
    void updateUser() {
        User expected = new User(1, "Antonio", "antonio@gmail.com");
        underTest.updateUser(expected);
        User actual = underTest.getUserById(1);

        assertEquals(expected, actual);
    }

    @Test
    void deleteUser() {
        assertTrue(underTest.deleteUser(1));
    }

    @Test
    void bookTicket() {
        Ticket expected = new Ticket(1, 1, 1, STANDARD, 101);
        Ticket actual = underTest.bookTicket(1, 1, 101, STANDARD);

        assertEquals(expected, actual);
    }

    @Test
    void getBookedTickets() {
        underTest.bookTicket(1, 1, 101, STANDARD);
        List<Ticket> expected = List.of(new Ticket(1,1,1,STANDARD, 101));
        List<Ticket> actual = underTest.getBookedTickets(user1, 1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void testGetBookedTickets() {
        underTest.bookTicket(1, 1, 101, STANDARD);
        List<Ticket> expected = List.of(new Ticket(1,1,1,STANDARD, 101));
        List<Ticket> actual = underTest.getBookedTickets(new Event(1, "Avengers", date), 1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void cancelTicket() {
        underTest.bookTicket(1,1,101,STANDARD);

        assertTrue(underTest.cancelTicket(1));
    }

    @Test
    void getEventById() {
        Event actual = underTest.getEventById(1);

        assertEquals(new Event(1, "Avengers", date), actual);
    }

    @Test
    void getEventsByTitle() {
        List<Event> actual = underTest.getEventsByTitle("Avengers", 1,1);

        assertEquals(List.of(event1), actual);
    }

    @Test
    void getEventsForDay() {
        List<Event> actual = underTest.getEventsForDay(date, 1, 1);

        assertEquals(List.of(event1, event2), actual);
    }

    @Test
    void createEvent() {
        Event expected = new Event(3, "Transformers", date);

        assertEquals(expected, underTest.createEvent(expected));
    }

    @Test
    void updateEvent() {
        Event expected = new Event(1, "Transformers", date);

        assertEquals(expected, underTest.updateEvent(expected));
    }

    @Test
    void deleteEvent() {
        assertTrue(underTest.deleteEvent(1));
    }
}