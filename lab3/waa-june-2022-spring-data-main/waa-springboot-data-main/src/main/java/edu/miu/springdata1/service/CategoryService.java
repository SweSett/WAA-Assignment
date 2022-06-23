package edu.miu.springdata1.service;

import edu.miu.springdata1.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    void delete(int id);

    Category getById(int id);

    List<Category> getAll();
}
