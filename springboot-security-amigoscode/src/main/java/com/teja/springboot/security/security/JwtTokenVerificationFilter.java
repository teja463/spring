package com.teja.springboot.security.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//    private static final Logger logger = LoggerFactory.getLogger(JwtTokenVerificationFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = authorization.replace("Bearer ", "");
        logger.info(token);
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
            logger.info(claims.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        filterChain.doFilter(request, response);
    }
}
