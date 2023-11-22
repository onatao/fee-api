package com.neidev.fee.controller;

import com.neidev.fee.Address;
import com.neidev.fee.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Address> findCep(@PathVariable String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findCep(cep));
    }
}
