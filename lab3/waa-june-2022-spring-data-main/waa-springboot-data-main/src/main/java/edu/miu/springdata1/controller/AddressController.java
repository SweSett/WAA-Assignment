package edu.miu.springdata1.controller;

import edu.miu.springdata1.entity.Address;
import edu.miu.springdata1.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddress(){
       return addressService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id) {
        var address = addressService.getById(id);
        return ResponseEntity.ok(address);
    }
    @PostMapping
    public void saveAddress(Address address){
        addressService.save(address);
    }

    @PutMapping
    public  void updateAddress(Address address){
        addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        addressService.delete(id);
    }
}
