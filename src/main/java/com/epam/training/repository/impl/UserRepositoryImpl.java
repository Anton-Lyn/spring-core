package com.epam.training.repository.impl;

import com.epam.training.model.User;
import com.epam.training.repository.UserRepository;
import com.epam.training.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private Storage storage;

    public User getUserById(Integer userId) {
        return storage.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return storage.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return storage.getUsersByName(name, pageSize, pageNum);
    }

    public User createUser(User user) {
        return storage.createUser(user);
    }

    public User updateUser(User user) {
        return storage.updateUser(user);
    }

    public boolean deleteUser(Integer userId) {
        return storage.deleteUser(userId);
    }
}
