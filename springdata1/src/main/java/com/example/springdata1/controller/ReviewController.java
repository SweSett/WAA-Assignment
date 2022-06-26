package com.example.springdata1.controller;

import com.example.springdata1.entity.Product;
import com.example.springdata1.entity.Review;
import com.example.springdata1.service.ProductService;
import com.example.springdata1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/reviews")
@CrossOrigin("*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Review p){
        reviewService.save(p);
        return ResponseEntity.ok("Success");
    }
    @GetMapping
    public ResponseEntity<Iterable<Review>> getAll(){
        Iterable<Review> list = reviewService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<List<Review>> getAllByProduct(@PathVariable int id){
        List<Review> list = reviewService.getAllByProduct(id);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getByID(@PathVariable int id){
        Review p = reviewService.getById(id);
        return ResponseEntity.ok(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Review p ,@PathVariable int id){
        reviewService.update(p,id);
        return ResponseEntity.ok("Success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        reviewService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
