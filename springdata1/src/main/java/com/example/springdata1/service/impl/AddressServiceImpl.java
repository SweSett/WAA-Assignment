package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Address;
import com.example.springdata1.entity.Category;
import com.example.springdata1.repo.AddressRepository;
import com.example.springdata1.repo.CategoryRepository;
import com.example.springdata1.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public Iterable<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        Optional<Address> result = addressRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Override
    public void update(Address a, int id) {
        Address add = addressRepository.findById(id).get();
        add.setId(a.getId());
        add.setCity(a.getCity());
        add.setStreet(a.getStreet());
        add.setUser(a.getUser());
        add.setZip(a.getZip());
        addressRepository.save(add);
    }

    @Override
    public void delete(int id) {
        Address add = addressRepository.findById(id).get();
        addressRepository.delete(add);
    }

    @Override
    public void save(Address a) {
        addressRepository.save(a);
    }
}
