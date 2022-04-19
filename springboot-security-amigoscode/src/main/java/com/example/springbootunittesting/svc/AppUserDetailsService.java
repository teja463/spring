package com.example.springbootunittesting.svc;

import com.example.springbootunittesting.model.AppUser;
import com.example.springbootunittesting.repos.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AppUserRepository appUserRepository;

    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserId(username).orElseThrow(() -> new RuntimeException("User Not foudn"));
        return User.builder().username(appUser.getUserId()).password(appUser.getPassword()).authorities(new ArrayList<>()).build();
    }
}
