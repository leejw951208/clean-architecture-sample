package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.GuestOrderSave;

public interface SaveGuestOrderPort {
    void save(GuestOrderSave domain);
}
