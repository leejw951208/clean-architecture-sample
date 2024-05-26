package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.QGuestEntity;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.hexagonalarchitecture.guest.adapter.out.persistence.QGuestEntity.guestEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.QGuestOrderEntity.guestOrderEntity;

@Repository
@RequiredArgsConstructor
public class GuestOrderEntityRepositoryImpl implements GuestOrderEntityRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<String> findLastOrderNumber() {
        return Optional.ofNullable(
                queryFactory
                        .select(guestOrderEntity.orderNumber)
                        .from(guestOrderEntity)
                        .orderBy(guestOrderEntity.id.desc())
                        .limit(1)
                        .fetchOne()
        );
    }

    @Override
    public Optional<Order> findOne(String orderNumber) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.fields(Order.class,
                                guestOrderEntity.id,
                                guestEntity.name,
                                guestOrderEntity.orderDate
                        ))
                        .from(guestOrderEntity)
                        .innerJoin(guestEntity).on(guestOrderEntity.guest.eq(guestEntity))
                        .where(guestOrderEntity.orderNumber.eq(orderNumber))
                        .fetchOne()
        );
    }
}
