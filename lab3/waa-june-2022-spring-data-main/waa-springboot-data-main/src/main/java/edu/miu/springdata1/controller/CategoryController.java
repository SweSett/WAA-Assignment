package edu.miu.springdata1.controller;

import edu.miu.springdata1.entity.Category;
import edu.miu.springdata1.entity.Product;
import edu.miu.springdata1.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id){
        var category = categoryService.getById(id);
        return  ResponseEntity.ok(category);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategoryId(@PathVariable int id){
      return   categoryService.getById(id).getProducts();
    }

    @PostMapping
    public  void saveCategory(Category category){
        categoryService.save(category);
    }

    @PutMapping
    public  void  updateCategory(Category category){
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }


}
