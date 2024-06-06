package com.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "customer firstName is required")
        String firstName,
        @NotNull(message = "customer lastName is required")

        String lastName,
        @NotNull(message = "customer email is required")
        @Email(message = "please provide valid email")
        String email,
        Address address
) {
}
