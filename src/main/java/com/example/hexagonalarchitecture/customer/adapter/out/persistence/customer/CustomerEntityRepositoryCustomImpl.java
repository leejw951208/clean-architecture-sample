package com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.hexagonalarchitecture.customer.adapter.out.persistence.QCustomerEntity.customerEntity;

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
        return Optional.empty();
    }
}
