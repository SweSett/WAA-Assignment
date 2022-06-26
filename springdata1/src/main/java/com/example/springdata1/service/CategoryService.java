package com.example.springdata1.service;

import com.example.springdata1.entity.Category;
import com.example.springdata1.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public Iterable<Category> getAll();

    public Category getById(int id);

    public void update(Category c, int id);

    public void delete(int id);

    public void save(Category c);
}
