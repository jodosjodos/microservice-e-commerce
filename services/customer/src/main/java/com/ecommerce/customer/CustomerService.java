package com.ecommerce.customer;

import com.ctc.wstx.util.StringUtil;
import com.ecommerce.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        var customer = repo.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public Void updateCustomer(CustomerRequest request) {
        var customer =
                repo.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(format("can't update customer :: No customer found with provided ID : %S",
                        request.id())));
        mergeCustomer(customer,
                request);
        repo.save(customer);
        return null;

    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }
} 
