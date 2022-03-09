package com.boc.ecommerceapi.service;

import com.boc.ecommerceapi.dto.mapper.UserMapper;
import com.boc.ecommerceapi.dto.model.UserDto;
import com.boc.ecommerceapi.model.User;
import com.boc.ecommerceapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> get(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> create(UserDto userDto) {
        return Optional.of( userRepository.save(UserMapper.toUser(userDto)));
    }

    @Override
    public String delete(long userId) {
        userRepository.deleteById(userId);
        return "user deleted with success";
    }

    @Override
    public Optional<User> update(User existingUserToUpdate,UserDto userDtoWithUpdate) {
        // -- Update existing user informations
        existingUserToUpdate.setName(userDtoWithUpdate.getName());
        existingUserToUpdate.setEmail(userDtoWithUpdate.getEmail());
        existingUserToUpdate.setGenderType(userDtoWithUpdate.getGenderType());

        // -- Update existing user in DB with new informations
        Optional<User> updatedUser = Optional.of(userRepository.save(existingUserToUpdate));

        return updatedUser;
    }


}
