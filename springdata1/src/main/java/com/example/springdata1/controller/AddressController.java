package com.example.springdata1.controller;

import com.example.springdata1.entity.Address;
import com.example.springdata1.entity.Review;
import com.example.springdata1.service.AddressService;
import com.example.springdata1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/address")
@CrossOrigin("*")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Address p){
        addressService.save(p);
        return ResponseEntity.ok("Success");
    }
    @GetMapping
    public ResponseEntity<Iterable<Address>> getAll(){
        Iterable<Address> list = addressService.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getByID(@PathVariable int id){
        Address p = addressService.getById(id);
        return ResponseEntity.ok(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Address p ,@PathVariable int id){
        addressService.update(p,id);
        return ResponseEntity.ok("Success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        addressService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
