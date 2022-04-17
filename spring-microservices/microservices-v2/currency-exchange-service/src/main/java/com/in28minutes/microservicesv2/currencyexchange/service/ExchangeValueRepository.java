package com.in28minutes.microservicesv2.currencyexchange.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {


    ExchangeValue findByFromAndTo(String from, String to);
}
