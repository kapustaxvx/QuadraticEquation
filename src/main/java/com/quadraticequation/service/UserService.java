package com.quadraticequation.service;

import com.quadraticequation.model.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userName);

    List<User> getUsers();
}
