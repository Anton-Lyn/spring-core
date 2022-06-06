package com.epam.training.storage.impl;

import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;
import com.epam.training.storage.Storage;

import java.util.ArrayList;
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

    public User getUserById(Integer userId) {
        return userStorage.get(userId);
    }

    public User getUserByEmail(String email) {
        for (User user : userStorage.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new RuntimeException("User not found!!!");
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> users = new ArrayList<>();
        for (User user : userStorage.values()) {
            if (user.getName().equals(name)) {
                users.add(user);
            }
        }

        return users;
    }

    public User createUser(User user) {
        return userStorage.put(user.getId(), user);
    }

    public User updateUser(User user) {
        return userStorage.put(user.getId(), user);
    }

    public boolean deleteUser(Integer userId) {
        return userStorage.values().removeIf(user -> user.getId().equals(userId));
    }

}
