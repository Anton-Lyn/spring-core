package com.epam.training.model;

import java.util.Objects;

public class Ticket {

    private Integer id;
    private Integer eventId;
    private Integer userId;
    private Category category;
    private Integer place;

    public Ticket(Integer id, Integer eventId, Integer userId, Category category, Integer place) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.category = category;
        this.place = place;
    }

    public Ticket () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", category=" + category +
                ", place=" + place +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(eventId, ticket.eventId) && Objects.equals(userId, ticket.userId) && category == ticket.category && Objects.equals(place, ticket.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, userId, category, place);
    }
}
