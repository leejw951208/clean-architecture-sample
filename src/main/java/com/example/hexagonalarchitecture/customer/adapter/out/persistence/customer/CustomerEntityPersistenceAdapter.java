package com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer;

import com.example.hexagonalarchitecture.customer.application.port.out.SaveCustomerPort;
import com.example.hexagonalarchitecture.customer.domain.Customer;
import com.example.hexagonalarchitecture.customer.shared.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerEntityPersistenceAdapter implements SaveCustomerPort {
    private final CustomerEntityJpaRepository customerEntityJpaRepository;
    private final CustomerEntityRepositoryCustom customerEntityRepositoryCustom;
    private final CustomerMapper customerMapper;

    @Override
    public void save(Customer customer) {
        CustomerEntity createdEntity = customerMapper.toEntity(customer);
        customerEntityJpaRepository.save(createdEntity);
    }
}
