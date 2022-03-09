package com.boc.ecommerceapi.controller;

import com.boc.ecommerceapi.dto.model.AddressDto;
import com.boc.ecommerceapi.model.Address;
import com.boc.ecommerceapi.model.User;
import com.boc.ecommerceapi.service.AddressService;
import com.boc.ecommerceapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Resource(name = "addressService")
    private AddressService addressService;

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/{id}")
    public Address get(@PathVariable long id) {
        return addressService.get(id).orElseThrow(() -> new RuntimeException("Address not found : " + id));
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping
    public Address create(final @RequestBody AddressDto addressDto){
        User addressOwner = userService.get(addressDto.getAddressOwnerId()).orElseThrow(() -> new RuntimeException("User not found : " + addressDto.getAddressOwnerId()));

        return addressService.create(addressDto.getName(), addressOwner).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }
}
