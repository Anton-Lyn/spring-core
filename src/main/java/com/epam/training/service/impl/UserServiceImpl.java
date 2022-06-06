package com.epam.training.service.impl;

import com.epam.training.model.User;
import com.epam.training.repository.UserRepository;
import com.epam.training.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userRepository.getUsersByName(name, pageSize, pageNum);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public boolean deleteUser(Integer userId) {
        return userRepository.deleteUser(userId);
    }
}
