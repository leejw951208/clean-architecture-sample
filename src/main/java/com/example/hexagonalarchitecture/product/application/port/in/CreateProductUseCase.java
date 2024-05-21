package com.example.hexagonalarchitecture.product.application.port.in;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.CreateProductRequestDto;

import java.util.List;

public interface CreateProductUseCase {
    void createProduct(CreateProductRequestDto requestDto);
    void createProducts(List<CreateProductRequestDto> requestDtos);
}
