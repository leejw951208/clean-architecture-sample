package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
}
