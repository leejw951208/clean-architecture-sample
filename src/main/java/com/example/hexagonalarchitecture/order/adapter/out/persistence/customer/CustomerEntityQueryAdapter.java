package com.example.hexagonalarchitecture.order.adapter.out.persistence.customer;

import com.example.hexagonalarchitecture.order.application.port.out.FindCustomerPort;
import com.example.hexagonalarchitecture.order.domain.Customer;
import com.example.hexagonalarchitecture.order.shared.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerEntityQueryAdapter implements FindCustomerPort {
    private final CustomerEntityRepositoryCustom customerEntityRepositoryCustom;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<Customer> findByUserId(long userId) {
        Optional<CustomerEntity> findEntity = customerEntityRepositoryCustom.findByUserId(userId);
        return findEntity.map(customerMapper::toDomainWithId);
    }
}
