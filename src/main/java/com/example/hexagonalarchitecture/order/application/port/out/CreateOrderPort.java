package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface CreateOrderPort {
    void createOrder(Order order, List<Product> products);
}
