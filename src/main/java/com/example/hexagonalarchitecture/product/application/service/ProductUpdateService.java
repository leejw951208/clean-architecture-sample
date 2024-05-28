package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalarchitecture.product.application.port.in.ProductUpdateUseCases;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.application.port.out.ProductUpdatePort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateService implements ProductUpdateUseCases {
    private final ProductFindPort productFindPort;
    private final ProductUpdatePort productUpdatePort;
    private final ProductMapper productMapper;

    @Override
    public void updateProduct(long id, String name) {
        Product product = productFindPort.findById(id);
        ProductUpdate productUpdate = productMapper.fromProductToProductUpdate(product);
        productUpdate.updateName(name);
        productUpdatePort.update(productUpdate);
    }
}
