package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.QOrderProductEntity;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.QCustomerEntity.customerEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.QCustomerUserEntity.customerUserEntity;
import static com.example.hexagonalarchitecture.order.adapter.out.persistence.order.QOrderEntity.orderEntity;

import static com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.QOrderProductEntity.orderProductEntity;
import static com.example.hexagonalarchitecture.product.adapter.out.persistence.QProductEntity.productEntity;
import static com.example.hexagonalarchitecture.user.adapter.out.persistence.user.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class OrderEntityRepositoryCustomImpl implements OrderEntityRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Order> findDomainByUserId(long userId) {
        return queryFactory
                .select(Projections.fields(Order.class,
                        orderEntity.id,
                        customerEntity.name.as("customerName"),
                        orderEntity.orderNo,
                        orderEntity.orderStatus,
                        orderEntity.orderDate
                ))
                .from(orderEntity)
                .innerJoin(customerEntity).on(orderEntity.customerEntity.eq(customerEntity))
                .innerJoin(customerUserEntity).on(customerEntity.eq(customerUserEntity.customerEntity))
                .innerJoin(userEntity).on(customerUserEntity.userEntity.eq(userEntity))
                .where(userEntity.id.eq(userId))
                .fetch();
    }

    @Override
    public Optional<Order> findDomainByUserIdAndId(long userId, long id) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.fields(Order.class,
                                orderEntity.id,
                                customerEntity.name.as("customerName"),
                                orderEntity.orderNo,
                                orderEntity.orderStatus,
                                orderEntity.orderDate
                        ))
                        .from(orderEntity)
                        .innerJoin(customerEntity).on(orderEntity.customerEntity.eq(customerEntity))
                        .innerJoin(customerUserEntity).on(customerEntity.eq(customerUserEntity.customerEntity))
                        .innerJoin(userEntity).on(customerUserEntity.userEntity.eq(userEntity))
                        .where(
                                userEntity.id.eq(userId),
                                orderEntity.id.eq(id)
                        )
                        .fetchOne()
        );
    }

    @Override
    public Optional<Order> findDomainByOrderNo(String orderNo) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.fields(Order.class,
                                orderEntity.id,
                                customerEntity.name.as("customerName"),
                                orderEntity.orderNo,
                                orderEntity.orderStatus,
                                orderEntity.orderDate
                        ))
                        .from(orderEntity)
                        .innerJoin(customerEntity).on(orderEntity.customerEntity.eq(customerEntity))
                        .where(orderEntity.orderNo.eq(orderNo))
                        .fetchOne()
        );
    }

    @Override
    public List<Product> findProductsById(long id) {
        return queryFactory
                .select(Projections.fields(Product.class,
                        productEntity.id,
                        productEntity.productName,
                        productEntity.createdDate
                ))
                .from(productEntity)
                .innerJoin(orderProductEntity).on(productEntity.eq(orderProductEntity.productEntity))
                .where(orderProductEntity.orderEntity.id.eq(id))
                .fetch();
    }

    @Override
    public List<Product> findProductsByIdIn(List<Long> ids) {
        return queryFactory
                .select(Projections.fields(Product.class,
                        productEntity.id,
                        productEntity.productName,
                        productEntity.createdDate,
                        orderEntity.id.as("orderId")
                ))
                .from(productEntity)
                .innerJoin(orderProductEntity).on(productEntity.eq(orderProductEntity.productEntity))
                .innerJoin(orderEntity).on(orderProductEntity.orderEntity.eq(orderEntity))
                .where(orderEntity.id.in(ids))
                .fetch();
    }
}
