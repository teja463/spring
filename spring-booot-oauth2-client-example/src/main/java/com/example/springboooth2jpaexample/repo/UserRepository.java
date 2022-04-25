package com.example.springboooth2jpaexample.repo;

import com.example.springboooth2jpaexample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
