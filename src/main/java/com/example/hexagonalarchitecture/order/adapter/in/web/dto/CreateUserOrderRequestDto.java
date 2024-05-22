package com.example.hexagonalarchitecture.order.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreateUserOrderRequestDto {
    private Long userId;
    private List<Long> productIds;
}
