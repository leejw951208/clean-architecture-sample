package com.example.hexagonalarchitecture.order.shared.mapper;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.CustomerUserEntity;
import com.example.hexagonalarchitecture.order.domain.Customer;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;

public interface CustomerMapper {
    CustomerEntity toEntity(Customer customer);
    CustomerEntity toEntity(String name, int isUser);
    Customer toDomainWithId(CustomerEntity customerEntity);
    Customer toDomain(String name, int isUser);
    CustomerUserEntity toEntity(CustomerEntity customerEntity, UserEntity userEntity);
}
