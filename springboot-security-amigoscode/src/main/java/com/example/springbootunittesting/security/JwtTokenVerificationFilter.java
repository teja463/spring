package com.example.springbootunittesting.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtTokenVerificationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = authorization.replace("Bearer ", "");
        System.out.println(token);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("secret5k@4534foradsf".getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
            String userName = claims.getSubject();
            List<Map<String, String>> roles = (List<Map<String, String>>)claims.get("authorities");
            List<SimpleGrantedAuthority> authority = roles.stream().map(role -> new SimpleGrantedAuthority(role.get("authority"))).collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, authority);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(claims);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
