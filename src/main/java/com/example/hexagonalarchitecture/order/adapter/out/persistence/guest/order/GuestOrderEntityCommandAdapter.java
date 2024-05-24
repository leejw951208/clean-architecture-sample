package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.SaveGuestOrderPort;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GuestOrderEntityCommandAdapter implements SaveGuestOrderPort {
    private final GuestOrderEntityJpaRepository guestOrderEntityJpaRepository;
    private final GuestOrderDetailEntityJpaRepository guestOrderDetailEntityJpaRepository;

    @Override
    public void save(GuestOrderCommand domain) {

    }
}
