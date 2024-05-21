package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface FindOrderPort {
    Order findById(Long id);
    List<Product> findProductByOrderId(Long orderId);
}
