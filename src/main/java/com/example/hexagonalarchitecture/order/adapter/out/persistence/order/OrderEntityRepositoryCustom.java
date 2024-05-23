package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface OrderEntityRepositoryCustom {
    List<Order> findDomainByUserId(long userId);
    Optional<Order> findDomainByUserIdAndId(long userId, long id);
    Optional<Order> findDomainByOrderNo(String orderNo);
    List<Product> findProductsById(long id);
    List<Product> findProductsByIdIn(List<Long> ids);
}
