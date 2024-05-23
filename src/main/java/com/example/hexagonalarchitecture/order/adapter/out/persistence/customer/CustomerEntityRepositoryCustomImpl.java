package com.example.hexagonalarchitecture.order.adapter.out.persistence.customer;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.QCustomerUserEntity;
import com.example.hexagonalarchitecture.order.domain.Customer;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.QUserEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.QCustomerEntity.customerEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.QCustomerUserEntity.customerUserEntity;
import static com.example.hexagonalarchitecture.user.adapter.out.persistence.user.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class CustomerEntityRepositoryCustomImpl implements CustomerEntityRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<CustomerEntity> findById(long id) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(customerEntity)
                        .where(customerEntity.id.eq(id))
                        .fetchOne()
        );
    }

    @Override
    public Optional<CustomerEntity> findByUserId(long userId) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(customerEntity)
                        .innerJoin(customerUserEntity).on(customerEntity.eq(customerUserEntity.customerEntity))
                        .innerJoin(userEntity).on(customerUserEntity.userEntity.eq(userEntity))
                        .where(userEntity.id.eq(userId))
                        .fetchOne()
        );
    }
}
