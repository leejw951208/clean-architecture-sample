package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.UserOrderSave;

public interface UserOrderSavePort {
    void saveUserOrder(UserOrderSave domain);
}
