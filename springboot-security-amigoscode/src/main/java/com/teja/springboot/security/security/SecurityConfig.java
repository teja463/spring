package com.teja.springboot.security.security;

import com.teja.springboot.security.svc.AppUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserDetailsService appUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(AppUserDetailsService appUserDetailsService, PasswordEncoder passwordEncoder) {
        this.appUserDetailsService = appUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerificationFilter(), JwtUsernameAndPasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/", "index")
                .permitAll()
                .and()
                // Moved to method level annoation based
//                .authorizeRequests()
//                .antMatchers("/students")
//                .hasRole(STUDENT.name())
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/mgmt/students").hasAuthority(STUDENT_WRITE.getPermission())
//                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        // For HTTP Basic Based Login
//                .and()
//                .httpBasic();

        // For Form Based Login
//                .and()
//                .formLogin()
//                .loginPage("/mylogin")
//                .permitAll()
//                .loginProcessingUrl("/myloginurl").permitAll();
    }


    // Use for Inmemory based UserDetails Service
   /* @Bean
    public InMemoryUserDetailsManager userDetails() {
        UserDetails teja = User.builder()
                .username("student")
                .password(passwordEncoder.encode("test"))
                .authorities(STUDENT.getAuthorities())
//                .roles(STUDENT.name())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("test"))
                .authorities(ADMIN.getAuthorities())
//                .roles(ADMIN.toString())
                .build();
        UserDetails tom = User.builder()
                .username("admin_trainee")
                .password(passwordEncoder.encode("test"))
                .authorities(ADMIN_TRAINEE.getAuthorities())
//                .roles(ADMIN_TRAINEE.toString())
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(teja, admin, tom);
        return inMemoryUserDetailsManager;
    }*/
}
