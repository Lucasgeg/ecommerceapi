package com.boc.ecommerceapi.service;

import com.boc.ecommerceapi.model.Address;
import com.boc.ecommerceapi.model.User;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> get(long addressId);
    List<Address> getAll();
    Optional<Address> create(String name, User addressOwner);
    Optional<Address> getByOwnerId(long addressOwnerId);
}
