package com.aftab.demo.controller;

import com.aftab.demo.entity.User;
import com.aftab.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController
{
    private final UserRepository userRepository;

    @GetMapping
    public Page<User> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return userRepository.findAll(
                PageRequest.of(page, size, Sort.by(sortBy))
        );
    }

    @PostMapping
    public User creatUser(@Valid @RequestBody User user)
    {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        userRepository.deleteById(id);
        return "User delete successfully";
    }

    @PutMapping("/{id}")
    public User updataeUser(@PathVariable Long id, @RequestBody User updateUser)
    {
        return  userRepository.findById(id).map(user -> {
           user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
           return userRepository.save(user);
        }).orElse(null);
    }
}
