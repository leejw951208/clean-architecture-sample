package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;

public interface TrackOrderUseCase {
    TrackOrderResponseDto trackUserOrder(Long id);
    TrackOrderResponseDto trackOrder(Long id);
}
