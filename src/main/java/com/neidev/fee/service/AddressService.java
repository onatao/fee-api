package com.neidev.fee.service;

import com.neidev.fee.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    // viacep.com.br/ws/cep/json/

    public Address findCep(String cep) {
       RestTemplate template = new RestTemplate();
       try {
           var response = template.getForEntity(
                   String.format("https://viacep.com.br/ws/%s/json/", cep), Address.class);
           return response.getBody();
       } catch (HttpClientErrorException e) {
           throw new HttpClientErrorException(e.getStatusCode());
       }
    }

}
