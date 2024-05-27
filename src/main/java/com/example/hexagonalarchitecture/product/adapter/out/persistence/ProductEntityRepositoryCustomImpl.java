package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail.QUserOrderDetailEntity.userOrderDetailEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.QUserOrderEntity.userOrderEntity;
import static com.example.hexagonalarchitecture.product.adapter.out.persistence.QProductEntity.productEntity;

@Repository
@RequiredArgsConstructor
public class ProductEntityRepositoryCustomImpl implements ProductEntityRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<ProductEntity> findByOrderId(long orderId) {
        return queryFactory
                .selectFrom(productEntity)
                .innerJoin(userOrderDetailEntity).on(productEntity.eq(userOrderDetailEntity.product))
                .innerJoin(userOrderEntity).on(userOrderDetailEntity.userOrder.eq(userOrderEntity))
                .where(userOrderEntity.id.eq(orderId))
                .fetch();
    }

    @Override
    public List<ProductEntity> findByIds(List<Long> ids) {
        return queryFactory
                .selectFrom(productEntity)
                .where(productEntity.id.in(ids))
                .fetch();
    }
}
