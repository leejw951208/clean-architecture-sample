package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.customer.domain.Customer;
import com.example.hexagonalarchitecture.order.domain.CommandOrder;
import com.example.hexagonalarchitecture.order.domain.QueryOrder;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.domain.User;

import java.util.List;

public interface SaveOrderPort {
    void save(CommandOrder order);
    void save(CommandOrder order, User user);
}
