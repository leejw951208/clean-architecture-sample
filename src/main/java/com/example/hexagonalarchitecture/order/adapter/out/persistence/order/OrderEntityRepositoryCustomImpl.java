package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.domain.QueryOrder;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.hexagonalarchitecture.customer.adapter.out.persistence.QCustomerEntity.customerEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.order.QOrderEntity.orderEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.QOrderProductEntity.orderProductEntity;
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
    public Optional<QueryOrder> findDomainById(Long id) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.fields(QueryOrder.class,
                                orderEntity.id,
                                customerEntity.name.as("customerName"),
                                orderEntity.orderStatus,
                                orderEntity.orderDate
                        ))
                        .from(orderEntity)
                        .innerJoin(customerEntity).on(orderEntity.customerEntity.eq(customerEntity))
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
