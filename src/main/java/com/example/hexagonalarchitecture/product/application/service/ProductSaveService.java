package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalarchitecture.product.application.port.in.ProductSaveUseCases;
import com.example.hexagonalarchitecture.product.application.port.out.ProductSavePort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSaveService implements ProductSaveUseCases {
    private final ProductSavePort productSavePort;

    @Override
    public void saveProducts(List<ProductSave> productSaves) {
        productSavePort.saveAll(productSaves);
    }
}
