package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Customer;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.domain.User;

import java.util.List;

public interface SaveOrderPort {
    void save(long userId, List<Long> productIds);
    void save(String name, List<Long> productIds);
}
