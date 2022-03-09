package com.boc.ecommerceapi.service;

import com.boc.ecommerceapi.model.Address;
import com.boc.ecommerceapi.model.User;
import com.boc.ecommerceapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("addressService")
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Optional<Address> get(long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> create(String name, User addressOwner) {

        Optional<Address> addressExistWithOwnerId = getByOwnerId(addressOwner.getId());

        if (addressExistWithOwnerId.isPresent()){
            addressExistWithOwnerId.get().setName(name);

            return Optional.of(addressRepository.save(addressExistWithOwnerId.get()));
        }

        Address address = new Address();
        address.setName(name);
        address.setUser(addressOwner);

        return Optional.of(addressRepository.save(address));
    }

    @Override
    public Optional<Address> getByOwnerId(long addressOwnerId) {
        return addressRepository.findByUserId(addressOwnerId);
    }

}
