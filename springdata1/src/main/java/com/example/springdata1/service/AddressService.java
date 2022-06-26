package com.example.springdata1.service;

import com.example.springdata1.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    public Iterable<Address> getAll();

    public Address getById(int id);

    public void update(Address c, int id);

    public void delete(int id);

    public void save(Address c);
}
