package edu.miu.springdata1.service;

import edu.miu.springdata1.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);

    void delete(int id);

    Review getById(int id);

    List<Review> getAll();
}
