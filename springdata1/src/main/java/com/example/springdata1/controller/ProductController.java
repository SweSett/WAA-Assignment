package com.example.springdata1.controller;

import com.example.springdata1.annotation.ExecutionTime;
import com.example.springdata1.annotation.PostCheck;
import com.example.springdata1.entity.Product;
import com.example.springdata1.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    @PostCheck
    @ExecutionTime
    public ResponseEntity<String> save(@RequestBody Product p){
        productService.save(p);
        return ResponseEntity.ok("Success");
    }
    @GetMapping
    @ExecutionTime
    public ResponseEntity<Iterable<Product>> getAll(@RequestParam Optional<Double> minPrice,@RequestParam Optional<String> category, @RequestParam Optional<Double> maxPrice,@RequestParam Optional<String> keyword,@RequestParam Optional<Integer> user_id){
        if (minPrice.isPresent()) {
            Iterable<Product> list = productService.findProduct(minPrice.get());
            return ResponseEntity.ok(list);

        }else if(category.isPresent() && maxPrice.isPresent()){
            List<Product> result = productService.findProductByCat2(category.get(),maxPrice.get());
            return ResponseEntity.ok(result);
        }else if(keyword.isPresent()){
            List<Product>result = productService.findByName2(keyword.get());
            return ResponseEntity.ok(result);
        }else if(user_id.isPresent()){
            List<Product>result = productService.findByUser2(user_id.get());
            return ResponseEntity.ok(result);
        }
        else{
            Iterable<Product> list = productService.getAll();
            return ResponseEntity.ok(list);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getByID(@PathVariable int id){
        Product p = productService.getById(id);
        return ResponseEntity.ok(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Product p ,@PathVariable int id){
        productService.update(p,id);
        return ResponseEntity.ok("Success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        productService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
