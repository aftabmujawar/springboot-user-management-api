package com.aftab.demo.controller;

import com.aftab.demo.entity.User;
import com.aftab.demo.repository.UserRepository;
import com.aftab.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.aftab.demo.dto.LoginRequest;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController
{
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
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
    public User createUser(@Valid @RequestBody User user)
    {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

            if(updateUser.getPassword() != null && !updateUser.getPassword().isEmpty())
            {
                user.setPassword(passwordEncoder.encode(updateUser.getPassword()));
            }

           return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
