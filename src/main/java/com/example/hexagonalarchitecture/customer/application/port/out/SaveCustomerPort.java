package com.example.hexagonalarchitecture.customer.application.port.out;

import com.example.hexagonalarchitecture.customer.domain.Customer;

public interface SaveCustomerPort {
    void save(Customer customer);
}
