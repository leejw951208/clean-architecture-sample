package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.CreateProductRequestDto;
import com.example.hexagonalarchitecture.product.application.port.in.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreateProductController {
    private final CreateProductUseCase createProductUseCase;

    @PostMapping("/api/product")
    public ResponseEntity<String> createProduct(CreateProductRequestDto dto) {
        createProductUseCase.createProduct(dto);
        return ResponseEntity.ok("succeed");
    }

    @PostMapping("/api/products")
    public ResponseEntity<String> createProducts(List<CreateProductRequestDto> dtos) {
        createProductUseCase.createProducts(dtos);
        return ResponseEntity.ok("succeed");
    }
}
