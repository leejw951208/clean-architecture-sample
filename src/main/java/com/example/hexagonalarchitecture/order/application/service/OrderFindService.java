package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.application.port.in.OrderFindUseCases;
import com.example.hexagonalarchitecture.order.application.port.out.GuestOrderFindPort;
import com.example.hexagonalarchitecture.order.application.port.out.UserOrderFindPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderFindService implements OrderFindUseCases {
    private final UserOrderFindPort userOrderFindPort;
    private final GuestOrderFindPort guestOrderFindPort;
    private final ProductFindPort productFindPort;

    @Override
    @Transactional(readOnly = true)
    public Order findOrder(long orderId) {
        Order order = userOrderFindPort.findByOrderId(orderId);
        List<Product> products = productFindPort.findByOrderId(orderId);
        order.add(products);
        return order;
    }

    @Override
    @Transactional(readOnly = true)
    public Order findOrder(String orderNumber) {
        Order order = guestOrderFindPort.findByOrderNumber(orderNumber);
        List<Product> products = productFindPort.findByOrderId(order.getId());
        order.add(products);
        return order;
    }
}
