package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Customer;

import java.util.Optional;

public interface FindCustomerPort {
    Optional<Customer> findByUserId(long userId);
}
