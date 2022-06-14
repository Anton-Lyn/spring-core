package com.epam.training.repository.impl;

import com.epam.training.model.Event;
import com.epam.training.repository.EventRepository;
import com.epam.training.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    private Storage storage;

    @Override
    public Event getEventById(Integer eventId) {
        return storage.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return storage.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return storage.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return storage.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return storage.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(Integer eventId) {
        return storage.deleteEvent(eventId);
    }
}
