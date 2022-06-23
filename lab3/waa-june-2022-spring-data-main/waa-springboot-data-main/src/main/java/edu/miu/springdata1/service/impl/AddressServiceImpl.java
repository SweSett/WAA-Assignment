package edu.miu.springdata1.service.impl;

import edu.miu.springdata1.entity.Address;
import edu.miu.springdata1.entity.Product;
import edu.miu.springdata1.repo.AddressRepo;
import edu.miu.springdata1.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    @Override
    public void save(Address add) {
        addressRepo.save(add);
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }

    @Override
    public Address getById(int id) {
        return addressRepo.findById(id).get();
    }

    @Override
    public List<Address> getAll() {
        var result= new ArrayList<Address>();
        addressRepo.findAll().forEach(result::add);
        return result;
    }
}
