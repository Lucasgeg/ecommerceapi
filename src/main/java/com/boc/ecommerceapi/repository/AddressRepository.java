package com.boc.ecommerceapi.repository;

import com.boc.ecommerceapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    /**
     * Hibernate function to get Address by user id
     * The request like in sql => SELECT * FROM ADDRESSES WHERE USER_ID = 100
     *
     * @param userId address owner id
     * @return address find by owner id
     */
    Optional<Address> findByUserId(long userId);
}

