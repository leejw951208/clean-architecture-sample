package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.product.domain.Product;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.order.QOrderEntity.orderEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.orderProduct.QOrderProductEntity.orderProductEntity;
import static com.example.hexagonalarchitecture.product.adapter.out.persistence.QProductEntity.productEntity;

@Repository
@RequiredArgsConstructor
public class OrderEntityRepositoryCustomImpl implements OrderEntityRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<OrderEntity> findById(Long id) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(orderEntity)
                        .where(orderEntity.id.eq(id))
                        .fetchOne()
        );
    }

    @Override
    public List<Product> findProductByOrderId(Long orderId) {
        return queryFactory
                .select(Projections.fields(Product.class,
                        productEntity.id,
                        productEntity.productName,
                        productEntity.createdDate
                ))
                .from(productEntity)
                .innerJoin(orderProductEntity).on(productEntity.eq(orderProductEntity.productEntity))
                .where(orderProductEntity.orderEntity.id.eq(orderId))
                .fetch();
    }
}
