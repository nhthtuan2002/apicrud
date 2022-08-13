package com.example.apiwcrud.service;

import java.util.List;

public interface ClassService {
    public void saveClass(Class c);
    public void deleteClass(Integer id);
    public Class findById(Integer id);
    public List<Class> findAll();
    public List<Class> findAllByName(String name);
}