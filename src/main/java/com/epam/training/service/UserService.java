package com.epam.training.service;

import com.epam.training.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer userId);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name, int pageSize, int pageNum);
    User createUser(User user);
    User updateUser(User user);
    boolean deleteUser(Integer userId);

}
