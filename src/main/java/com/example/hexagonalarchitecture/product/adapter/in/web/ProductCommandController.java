package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.application.port.in.ProductSaveUseCases;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCommandController {
    private final ProductSaveUseCases productSaveUseCases;
    private final ProductMapper productMapper;

    @PostMapping("/api/products")
    public ResponseEntity<String> saveProducts(@RequestBody List<ProductSaveDto> dtos) {
        List<String> names = dtos.stream().map(ProductSaveDto::getName).toList();
        productSaveUseCases.saveProducts(productMapper.fromStrings(names));
        return new ResponseEntity<>("succeed", HttpStatus.CREATED);
    }
}
