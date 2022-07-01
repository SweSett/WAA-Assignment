package com.example.lab6.service.Impl;

import com.example.lab6.entity.Product;
import com.example.lab6.model.LoginRequest;
import com.example.lab6.model.LoginResponse;
import com.example.lab6.model.RefreshToken;
import com.example.lab6.repository.ProductRepository;
import com.example.lab6.security.JWTHelper;
import com.example.lab6.service.AuthService;
import com.example.lab6.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
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
        product.setId(p.getId());
        product.setPrice(p.getPrice());
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Override
    public void save(Product p) {
        productRepository.save(p);
    }
}
