package com.example.hexagonalarchitecture.order.shared.mapper;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.CustomerUserEntity;
import com.example.hexagonalarchitecture.order.domain.Customer;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .name(customer.getName())
                .isUser(customer.getIsUser())
                .build();
    }

    @Override
    public CustomerEntity toEntity(String name, int isUser) {
        return CustomerEntity.builder()
                .name(name)
                .isUser(isUser)
                .build();
    }

    @Override
    public Customer toDomainWithId(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .isUser(customerEntity.getIsUser())
                .build();
    }

    @Override
    public Customer toDomain(String name, int isUser) {
        return Customer.builder()
                .name(name)
                .isUser(isUser)
                .build();
    }

    @Override
    public CustomerUserEntity toEntity(CustomerEntity customerEntity, UserEntity userEntity) {
        return CustomerUserEntity.builder()
                .customerEntity(customerEntity)
                .userEntity(userEntity)
                .build();
    }
}
