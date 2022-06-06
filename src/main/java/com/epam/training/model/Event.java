package com.epam.training.model;

import java.util.Date;

public class Event {

    private Integer id;
    private String title;
    private Date date;

    public Event(Integer id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
