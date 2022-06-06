package com.epam.training.repository;

import com.epam.training.model.Event;

import java.util.Date;
import java.util.List;

public interface EventRepository {
    Event getEventById(Integer eventId);
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    boolean deleteEvent(Integer eventId);
}
