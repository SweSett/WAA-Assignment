package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Category;
import com.example.springdata1.entity.Product;
import com.example.springdata1.repo.CategoryRepository;
import com.example.springdata1.repo.ProductRepository;
import com.example.springdata1.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        Optional<Category> result = categoryRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Override
    public void update(Category c, int id) {
        Category cat = categoryRepository.findById(id).get();
        cat.setName(c.getName());
        cat.setId(c.getId());
        cat.setProducts(c.getProducts());
        categoryRepository.save(cat);
    }

    @Override
    public void delete(int id) {
        Category cat = categoryRepository.findById(id).get();
        categoryRepository.delete(cat);
    }

    @Override
    public void save(Category c) {
        categoryRepository.save(c);
    }
}
