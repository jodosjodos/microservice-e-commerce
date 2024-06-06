package com.ecommerce.customer;

public record CustomerRequest(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
