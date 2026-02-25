package com.aftab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aftab.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}