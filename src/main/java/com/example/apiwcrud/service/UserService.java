package com.example.apiwcrud.service;

import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public void deleteUser(Integer id);
    public User findById(Integer id);
    public List<User> findAll();
    public List<User> findAllByName(String name);
}