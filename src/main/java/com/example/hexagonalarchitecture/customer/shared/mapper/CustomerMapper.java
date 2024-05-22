package com.example.hexagonalarchitecture.customer.shared.mapper;

import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customeruser.CustomerUserEntity;
import com.example.hexagonalarchitecture.customer.domain.Customer;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;

public interface CustomerMapper {
    CustomerEntity toEntity(Customer customer);
    Customer toDomain(CustomerEntity customerEntity);
    Customer toDomain(User user);
    Customer toDomain(String name, int isUser);
    CustomerUserEntity toEntity(CustomerEntity customerEntity, UserEntity userEntity);
}
