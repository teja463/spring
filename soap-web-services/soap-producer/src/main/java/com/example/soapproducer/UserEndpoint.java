package com.example.soapproducer;

import io.spring.guides.gs_producing_web_service.Country;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import io.spring.guides.user_web_service.GetUserRequest;
import io.spring.guides.user_web_service.GetUserResponse;
import io.spring.guides.user_web_service.User;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/user-web-service";

   
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request){
    	GetUserResponse response = new GetUserResponse();
    	User user = new User();
    	user.setAge("32");
    	user.setName("Teja");
        response.setUser(user);;
        return response;
    }
    
    
}
