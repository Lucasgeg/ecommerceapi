package com.boc.ecommerceapi.controller;

import com.boc.ecommerceapi.dto.model.UserDto;
import com.boc.ecommerceapi.model.User;
import com.boc.ecommerceapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/{id}") //Key  GET + /users/id
    public User get(@PathVariable long id) {
        return userService.get(id).orElseThrow(() -> new RuntimeException("User not found : " + id));
    }

    @GetMapping //Key GET + /users/
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping // Key POST + /users/
    public User create(final @RequestBody UserDto user){
        return userService.create(user).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, final @RequestBody UserDto userDtoWithUpdate) {
        Optional<User> existingUserToUpdate = Optional.ofNullable(userService.get(id).orElseThrow(() -> new RuntimeException("User not found : " + id)));

        return userService.update(existingUserToUpdate.get(), userDtoWithUpdate)
                .orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return userService.delete(id);
    }

}
