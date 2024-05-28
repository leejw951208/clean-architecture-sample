package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalarchitecture.product.application.port.in.ProductFindUseCases;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFindService implements ProductFindUseCases {
    private final ProductFindPort productFindPort;

    @Override
    public Product findProduct(long id) {
        return productFindPort.findById(id);
    }
}
