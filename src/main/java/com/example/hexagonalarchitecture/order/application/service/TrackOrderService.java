package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.application.port.in.TrackOrderUseCase;
import com.example.hexagonalarchitecture.order.shared.mapper.guest.GuestOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackOrderService implements TrackOrderUseCase {
    private final GuestOrderMapper orderMapper;

}
