package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.GuestOrderEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.QGuestOrderEntity;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.QUserEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.QGuestOrderEntity.guestOrderEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.QUserOrderEntity.userOrderEntity;
import static com.example.hexagonalarchitecture.user.adapter.out.persistence.user.QUserEntity.userEntity;

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

    @Override
    public Optional<Order> findByOrderId(long orderId) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.fields(Order.class,
                                userOrderEntity.id,
                                userEntity.name,
                                userOrderEntity.orderDate
                        ))
                        .from(userOrderEntity)
                        .innerJoin(userEntity).on(userOrderEntity.user.eq(userEntity))
                        .where(userOrderEntity.id.eq(orderId))
                        .fetchOne()
        );
    }
}
