package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Product;
import com.example.springdata1.entity.Review;
import com.example.springdata1.repo.ProductRepository;
import com.example.springdata1.repo.ReviewRepository;
import com.example.springdata1.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository,ProductRepository productRepository){
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(int id) {
        Optional<Review> result = reviewRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Override
    public void update(Review r, int id) {
        Review review = reviewRepository.findById(id).get();
        review.setId(r.getId());
        review.setComment(r.getComment());
        review.setUser(r.getUser());
        reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {
        Review review = reviewRepository.findById(id).get();
        reviewRepository.delete(review);
    }

    @Override
    public void save(Review r) {
        reviewRepository.save(r);
    }

    @Override
    public List<Review> getAllByProduct(int id) {
        Product p = productRepository.findById(id).get();
        return reviewRepository.findAllByProduct(p);
    }

    @Override
    public List<Review> getAllByProduct2(int id) {
        return reviewRepository.findAllByProductID(id);
    }
}
