package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.application.port.in.TrackOrderUseCase;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrackOrderController {
    private final TrackOrderUseCase trackOrderUseCase;

    @GetMapping("/api/order/{id}")
    public ResponseEntity<TrackOrderResponseDto> trackOrder(@PathVariable("id") Long id) {
        return ResponseEntity.ok(trackOrderUseCase.trackOrder(id));
    }
}
