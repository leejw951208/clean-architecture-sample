package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.QUserOrderEntity.userOrderEntity;

@Repository
@RequiredArgsConstructor
public class UserOrderEntityRepositoryImpl implements UserOrderEntityRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<String> findLastOrderNumber() {
        return Optional.ofNullable(
                queryFactory
                        .select(userOrderEntity.orderNumber)
                        .from(userOrderEntity)
                        .orderBy(userOrderEntity.id.desc())
                        .limit(1)
                        .fetchOne()
        );
    }
}
