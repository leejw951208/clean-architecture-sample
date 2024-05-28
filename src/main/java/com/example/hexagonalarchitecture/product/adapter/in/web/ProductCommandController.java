package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.application.port.in.ProductSaveUseCases;
import com.example.hexagonalarchitecture.product.application.port.in.ProductUpdateUseCases;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCommandController {
    private final ProductSaveUseCases productSaveUseCases;
    private final ProductUpdateUseCases productUpdateUseCases;

    @PostMapping("/api/product")
    public ResponseEntity<String> saveProduct(@RequestBody ProductSaveDto dto) {
        productSaveUseCases.saveProduct(dto.getName());
        return new ResponseEntity<>("succeed", HttpStatus.CREATED);
    }

    @PutMapping("/api/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") long id, @RequestBody ProductSaveDto dto) {
        productUpdateUseCases.updateProduct(id, dto.getName());
        return new ResponseEntity<>("succeed", HttpStatus.OK);
    }
}
