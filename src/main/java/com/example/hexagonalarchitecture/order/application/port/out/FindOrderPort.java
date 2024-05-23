package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface FindOrderPort {
    List<Order> findByUserId(long userId);
    Order findByUserIdAndId(long userId, long id);
    Order findByOrderNo(String orderNo);
    List<Product> findProductsById(long id);
    List<Product> findProductsByIdIn(List<Long> ids);
}
