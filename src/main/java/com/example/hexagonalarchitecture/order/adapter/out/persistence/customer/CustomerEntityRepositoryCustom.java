package com.example.hexagonalarchitecture.order.adapter.out.persistence.customer;

import com.example.hexagonalarchitecture.order.domain.Customer;

import java.util.Optional;

public interface CustomerEntityRepositoryCustom {
    Optional<CustomerEntity> findById(long id);
    Optional<CustomerEntity> findByUserId(long userId);
}
