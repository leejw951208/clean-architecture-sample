package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;

public interface SaveGuestOrderPort {
    void save(GuestOrderCommand domain);
}
