package com.example.hexagonalarchitecture.customer.shared.mapper;

import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customeruser.CustomerUserEntity;
import com.example.hexagonalarchitecture.customer.domain.Customer;
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
    public Customer toDomain(CustomerEntity entity) {
        return Customer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    @Override
    public Customer toDomain(User user) {
        return Customer.builder()
                .name(user.getName())
                .isUser(1)
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
