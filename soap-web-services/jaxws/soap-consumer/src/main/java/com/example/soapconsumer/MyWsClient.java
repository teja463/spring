package com.example.soapconsumer;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MyWsClient extends WebServiceGatewaySupport {

    public void sendCountryRequest(String name){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");

        getWebServiceTemplate().setDefaultUri("http://localhost:8080/ws/countries");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        System.out.println(response.getCountry().getName());
        System.out.println(response.getCountry().getCapital());
        System.out.println(response.getCountry().getCurrency());
        System.out.println(response.getCountry().getPopulation());
    }
}
