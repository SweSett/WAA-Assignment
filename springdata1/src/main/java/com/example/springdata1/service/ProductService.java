package com.example.springdata1.service;

import com.example.springdata1.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    public Iterable<Product> getAll();

    public Product getById(int id);

    public void update(Product p, int id);

    public void delete(int id);

    public void save(Product p);

    public List<Product> findProduct(Double price);
    public List<Product> findProduct2(Double price);

    public List<Product> findProductByCat(String c, Double price);

    public List<Product> findProductByCat2(String c, Double price);

    public List<Product> findByName(String name);

    public List<Product> findByName2(String name);

    public List<Product> findByUser(int id);

    public List<Product> findByUser2(int id);
}
