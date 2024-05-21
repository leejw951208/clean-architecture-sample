package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;
import com.example.hexagonalarchitecture.order.domain.Order;

public interface TrackOrderUseCase {
    TrackOrderResponseDto trackOrder(Long id);
}
