package edu.miu.springdata1.service;

import edu.miu.springdata1.entity.Address;

import java.util.List;

public interface AddressService {
    void save(Address add);

    void delete(int id);

    Address getById(int id);

    List<Address> getAll();
}
