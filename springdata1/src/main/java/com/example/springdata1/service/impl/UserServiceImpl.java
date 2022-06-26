package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Product;
import com.example.springdata1.entity.Review;
import com.example.springdata1.entity.User;
import com.example.springdata1.repo.ReviewRepository;
import com.example.springdata1.repo.UserRepository;
import com.example.springdata1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Override
    public void update(User u, int id) {
        User user = userRepository.findById(id).get();
        user.setId(u.getId());
        user.setAddress(u.getAddress());
        user.setEmail(u.getEmail());
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setPassword(u.getPassword());
        user.setReviews(u.getReviews());
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public void save(User u) {
        userRepository.save(u);
    }
}
