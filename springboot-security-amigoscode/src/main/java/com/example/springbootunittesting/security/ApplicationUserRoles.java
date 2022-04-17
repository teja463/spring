package com.example.springbootunittesting.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.springbootunittesting.security.ApplicationUserPermissions.*;

public enum ApplicationUserRoles {
    STUDENT(new HashSet<>()),
    ADMIN(Stream.of(COURSES_READ, COURSES_WRITE, STUDENT_READ, STUDENT_WRITE).collect(Collectors.toSet())),
    ADMIN_TRAINEE(Stream.of(COURSES_READ, STUDENT_READ).collect(Collectors.toSet()));

    private Set<ApplicationUserPermissions> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermissions> getPermissions() {
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> authorities = this.getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}