package edu.miu.springdata1.service.impl;

import edu.miu.springdata1.entity.Review;
import edu.miu.springdata1.repo.ReviewRepo;
import edu.miu.springdata1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void delete(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public Review getById(int id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public List<Review> getAll() {
        var result = new ArrayList<Review>();
        reviewRepo.findAll().forEach(result::add);
        return result;
    }
}
