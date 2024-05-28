package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductFindDto;
import com.example.hexagonalarchitecture.product.application.port.in.ProductFindUseCases;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {
    private final ProductFindUseCases productFindUseCases;
    private final ProductMapper productMapper;

    @GetMapping("/api/product/{id}")
    public ResponseEntity<ProductFindDto> findProduct(@PathVariable("id") long id) {
        Product product = productFindUseCases.findProduct(id);
        ProductFindDto productFindDto = productMapper.fromProductToProductFindDto(product);
        return new ResponseEntity<>(productFindDto, HttpStatus.OK);
    }
}
