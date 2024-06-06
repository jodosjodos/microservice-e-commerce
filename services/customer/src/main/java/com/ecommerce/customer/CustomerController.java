package com.ecommerce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private  final  CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return  ResponseEntity.ok(service.createCustomer(request));
    }
    @PutMapping
    public  ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request){
        return  ResponseEntity.ok(service.updateCustomer(request));
    }
}