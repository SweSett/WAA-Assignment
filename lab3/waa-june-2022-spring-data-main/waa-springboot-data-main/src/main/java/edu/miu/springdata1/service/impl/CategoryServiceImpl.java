package edu.miu.springdata1.service.impl;

import edu.miu.springdata1.entity.Category;
import edu.miu.springdata1.repo.CategoryRepo;
import edu.miu.springdata1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Category getById(int id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<Category> getAll() {

        var result = new ArrayList<Category>();
        categoryRepo.findAll().forEach(result::add);
        return result;
    }
}
