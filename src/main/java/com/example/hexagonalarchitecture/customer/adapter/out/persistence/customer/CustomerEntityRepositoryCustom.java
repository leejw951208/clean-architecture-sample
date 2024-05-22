package com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer;

import java.util.Optional;

public interface CustomerEntityRepositoryCustom {
    Optional<CustomerEntity> findById(long id);
    Optional<CustomerEntity> findByUserId(long userId);
}
