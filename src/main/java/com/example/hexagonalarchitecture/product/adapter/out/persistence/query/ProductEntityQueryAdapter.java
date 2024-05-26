package com.example.hexagonalarchitecture.product.adapter.out.persistence.query;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepository;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductEntityQueryAdapter implements ProductFindPort {
    private final ProductEntityRepository productEntityRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findByIds(long orderId) {
        List<ProductEntity> productEntities = productEntityRepository.findProducts(orderId);
        return productMapper.fromEntities(productEntities);
    }

    @Override
    public List<Product> findByIds(List<Long> ids) {
        List<ProductEntity> productEntities = productEntityRepository.findProducts(ids);
        return productMapper.fromEntities(productEntities);
    }
}
