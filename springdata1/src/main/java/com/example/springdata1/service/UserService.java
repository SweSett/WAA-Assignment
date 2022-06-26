package com.example.springdata1.service;

import com.example.springdata1.entity.Category;
import com.example.springdata1.entity.Product;
import com.example.springdata1.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public Iterable<User> getAll();

    public User getById(int id);

    public void update(User u, int id);

    public void delete(int id);

    public void save(User u);
}
