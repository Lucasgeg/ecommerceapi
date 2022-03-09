package com.boc.ecommerceapi.dto.model;

public class AddressDto {
    String name;
    long addressOwnerId;

    public AddressDto(String name, long addressOwnerId) {
        this.name = name;
        this.addressOwnerId = addressOwnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAddressOwnerId() {
        return addressOwnerId;
    }

    public void setAddressOwnerId(long addressOwnerId) {
        this.addressOwnerId = addressOwnerId;
    }
}
