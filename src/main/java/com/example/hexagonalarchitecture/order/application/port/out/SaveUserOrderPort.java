package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import com.example.hexagonalarchitecture.order.domain.user.UserOrderCommand;

public interface SaveUserOrderPort {
    void save(UserOrderCommand domain);
}
