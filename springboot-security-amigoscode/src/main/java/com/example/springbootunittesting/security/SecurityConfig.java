package com.example.springbootunittesting.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.springbootunittesting.security.ApplicationUserPermissions.*;
import static com.example.springbootunittesting.security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/students")
                .hasRole(STUDENT.name())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/mgmt/students").hasAuthority(STUDENT_WRITE.getPermission())
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    @Bean
    public InMemoryUserDetailsManager userDetails() {
        UserDetails teja = User.builder()
                .username("student")
                .password(passwordEncoder.encode("student"))
                .authorities(STUDENT.getAuthorities())
//                .roles(STUDENT.name())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities(ADMIN.getAuthorities())
//                .roles(ADMIN.toString())
                .build();
        UserDetails tom = User.builder()
                .username("admin_trainee")
                .password(passwordEncoder.encode("admin_trainee"))
                .authorities(ADMIN_TRAINEE.getAuthorities())
//                .roles(ADMIN_TRAINEE.toString())
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(teja, admin, tom);
        return inMemoryUserDetailsManager;
    }
}
