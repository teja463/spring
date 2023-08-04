package com.teja.springboot.security.repos;

import com.teja.springboot.security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUserId(String userId);
}
