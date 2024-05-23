package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import com.example.hexagonalarchitecture.order.application.port.out.SaveOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {
    private final SaveOrderPort saveOrderPort;

    @Override
    @Transactional
    public void createOrder(long userId, List<Long> productIds) {
        saveOrderPort.save(userId, productIds);
    }

    @Override
    @Transactional
    public void createOrder(String customerName, List<Long> productIds) {
        saveOrderPort.save(customerName, productIds);
    }
}
