package com.epam.training.utils;

import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileParser {

    private static final String REGEX = ";";
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String USERS_PATH = "src/main/resources/user-data.txt";
    private static final String TICKETS_PATH = "src/main/resources/ticket-data.txt";
    private static final String EVENTS_PATH = "src/main/resources/event-data.txt";

    private FileParser() {
        throw new UnsupportedOperationException();
    }

    public static Map<Integer, Event> parseEvents() throws FileNotFoundException,
            ParseException {
        Map<Integer, Event> events = new HashMap<>();
        File file = new File(EVENTS_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(REGEX);
                Integer eventId = Integer.parseInt(items[0]);
                String eventTitle = items[1];
                Date eventDate = new SimpleDateFormat(DATE_FORMAT).parse(items[2]);
                Event event = new Event(eventId, eventTitle, eventDate);
                events.put(eventId, event);
            }
        }

        return events;
    }

    public static Map<Integer, Ticket> parseTickets() throws FileNotFoundException {
        Map<Integer, Ticket> tickets = new HashMap<>();
        File file = new File(TICKETS_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(REGEX);
                Integer ticketId = Integer.parseInt(items[0]);
                Integer eventId = Integer.parseInt(items[1]);
                Integer placeId = Integer.parseInt(items[2]);
                Ticket ticket = new Ticket();
                ticket.setId(ticketId);
                ticket.setEventId(eventId);
                ticket.setPlace(placeId);
                tickets.put(ticketId, ticket);
            }
        }

        return tickets;
    }

    public static Map<Integer, User> parseUsers() throws FileNotFoundException {
        Map<Integer, User> users = new HashMap<>();
        File file = new File(USERS_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(REGEX);
                Integer userId = Integer.parseInt(items[0]);
                String name = items[1];
                String email = items[2];
                User user = new User(userId, name, email);
                users.put(userId, user);
            }
        }

        return users;
    }
}
