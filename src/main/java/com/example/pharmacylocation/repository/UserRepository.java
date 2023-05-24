package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
