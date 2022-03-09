package com.boc.ecommerceapi.dto.mapper;

import com.boc.ecommerceapi.dto.model.UserDto;
import com.boc.ecommerceapi.model.User;

import java.util.Date;

public class UserMapper {

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setGenderType(userDto.getGenderType());
        user.setCreatedAt(new Date());

        return user;
    }

}
