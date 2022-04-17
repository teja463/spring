package com.example.soapproducer;

import io.spring.guides.gs_producing_web_service.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CountryRepository countryRepository;

    public CountryEndpoint(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        Country country = countryRepository.findCountry(request.getName());
        response.setCountry(country);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "myCountryRequest")
    @ResponsePayload
    public MyCountryResponse getCountry(@RequestPayload MyCountryRequest request){
        MyCountryResponse response = new MyCountryResponse();
        Country country = countryRepository.findCountry(request.getName());
        country.setName(country.getName() + " ---- new");
        response.setCountry(country);
        return response;
    }
}
