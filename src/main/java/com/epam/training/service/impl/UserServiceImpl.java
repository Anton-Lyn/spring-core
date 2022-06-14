package com.epam.training.service.impl;

import com.epam.training.model.User;
import com.epam.training.repository.UserRepository;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
