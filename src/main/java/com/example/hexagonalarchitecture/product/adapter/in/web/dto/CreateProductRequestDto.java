package com.example.hexagonalarchitecture.product.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductRequestDto {
    private String productName;
}
