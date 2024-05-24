package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.application.port.in.TrackOrderUseCase;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QueryOrderController {
    private final TrackOrderUseCase trackOrderUseCase;

}
