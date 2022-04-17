package com.in28minutes.microservicesv2.springcloudapigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class LoggingFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Requesed uri is {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
