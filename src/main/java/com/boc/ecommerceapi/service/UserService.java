package com.boc.ecommerceapi.service;

import com.boc.ecommerceapi.dto.model.UserDto;
import com.boc.ecommerceapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Get user by id
     *
     * @param userId  user identifiant
     * @return User find by id
     */
    Optional<User> get(long userId);

    /**
     * Get list of users
     *
     * @return list of users
     */
    List<User> getAll();

    /**
     * Create a new user
     *
     * @param userDto to create
     * @return a new user created
     */
    Optional<User> create(UserDto userDto);

    /**
     * Delete user by id
     *
     * @param userId  user identifiant
     * @return delete user by id
     */
    String delete(long userId);

    /**
     * Update a existing user
     *
     * @param existingUserToUpdate existing user object
     * @param userDtoWithUpdate user dto with informations to update
     * @return User updated
     */
    Optional<User> update(User existingUserToUpdate,UserDto userDtoWithUpdate);
}
