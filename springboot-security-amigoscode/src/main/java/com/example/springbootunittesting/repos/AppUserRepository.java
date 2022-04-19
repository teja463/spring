package com.example.springbootunittesting.repos;

import com.example.springbootunittesting.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUserId(String userId);
}
