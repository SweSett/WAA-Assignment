package com.example.springdata1.controller;

import com.example.springdata1.entity.Category;
import com.example.springdata1.entity.Product;
import com.example.springdata1.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/categories")
@CrossOrigin("*")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Category c){
        categoryService.save(c);
        return ResponseEntity.ok("Success");
    }
    @GetMapping
    public ResponseEntity<Iterable<Category>> getAll(){
        Iterable<Category> list = categoryService.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getByID(@PathVariable int id){
        Category c = categoryService.getById(id);
        return ResponseEntity.ok(c);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Category c ,@PathVariable int id){
        categoryService.update(c,id);
        return ResponseEntity.ok("Success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        categoryService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
