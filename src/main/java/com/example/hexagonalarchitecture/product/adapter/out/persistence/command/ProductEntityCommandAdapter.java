package com.example.hexagonalarchitecture.product.adapter.out.persistence.command;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.application.port.out.ProductSavePort;
import com.example.hexagonalarchitecture.product.application.port.out.ProductUpdatePort;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductEntityCommandAdapter implements ProductSavePort, ProductUpdatePort {
    private final ProductEntityJpaRepository productEntityJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public void save(ProductSave productSave) {
        ProductEntity productEntity = productMapper.fromProductSave(productSave);
        productEntityJpaRepository.save(productEntity);
    }

    @Override
    public void update(ProductUpdate productUpdate) {
        ProductEntity productEntity = productMapper.fromProductUpdate(productUpdate);
        productEntity.updateName(productUpdate.getName());
    }
}
