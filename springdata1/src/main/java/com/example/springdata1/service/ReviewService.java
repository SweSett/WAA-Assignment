package com.example.springdata1.service;

import com.example.springdata1.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public Iterable<Review> getAll();

    public Review getById(int id);

    public void update(Review r, int id);

    public void delete(int id);

    public void save(Review r);

    public List<Review> getAllByProduct(int id);

    public List<Review> getAllByProduct2(int id);
}
