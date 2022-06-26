package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Category;
import com.example.springdata1.entity.Product;
import com.example.springdata1.entity.User;
import com.example.springdata1.repo.CategoryRepository;
import com.example.springdata1.repo.ProductRepository;
import com.example.springdata1.repo.UserRepository;
import com.example.springdata1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,UserRepository userRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Override
    public void update(Product p, int id) {
        Product product = productRepository.findById(id).get();
        product.setName(p.getName());
        product.setCategory(p.getCategory());
        product.setId(p.getId());
        product.setPrice(p.getPrice());
        product.setRating(p.getRating());
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Override
    public void save(Product p) {
        Optional<Category> c= categoryRepository.findById(p.getCategory().getId());
        if(c.isPresent()) {
           p.setCategory(c.get());
        }else{
            categoryRepository.save(p.getCategory());
        }
        productRepository.save(p);
    }

    @Override
    public List<Product> findProduct(Double price){
        return productRepository.findProductByPriceGreaterThan(price==0?price:price-1);
    }
    @Override
    public List<Product> findProduct2(Double price){
        return productRepository.findProduct(price==0?price:price-1);
    }

    @Override
    public List<Product> findProductByCat(String c,Double price){
        return productRepository.findAllByCategoryNameAndPriceLessThan(c,price+1);
    }

    @Override
    public List<Product> findProductByCat2(String c,Double price){
        return productRepository.findProductByCat(c,price+1);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> findByName2(String name) {
        return productRepository.findProductByPName("%"+name+"%");
    }

    @Override
    public List<Product> findByUser(int id) {
        User user = userRepository.findById(id).get();
        return productRepository.findAllByUser(user);
    }

    @Override
    public List<Product> findByUser2(int id) {
        return productRepository.findByUserID(id);
    }
}
