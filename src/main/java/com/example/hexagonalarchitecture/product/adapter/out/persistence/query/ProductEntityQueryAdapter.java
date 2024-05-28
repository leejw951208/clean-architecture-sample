package com.example.hexagonalarchitecture.product.adapter.out.persistence.query;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepository;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class ProductEntityQueryAdapter implements ProductFindPort {
    private final ProductEntityRepository productEntityRepository;
    private final ProductEntityJpaRepository productEntityJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findByOrderId(long orderId) {
        List<ProductEntity> productEntities = productEntityRepository.findByOrderId(orderId);
        return productMapper.fromEntities(productEntities);
    }

    @Override
    public List<Product> findByIds(List<Long> ids) {
        List<ProductEntity> productEntities = productEntityRepository.findByIds(ids);
        return productMapper.fromEntities(productEntities);
    }

    @Override
    public Product findById(long id) {
        ProductEntity findProductEntity = productEntityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다."));
        return productMapper.fromEntity(findProductEntity);
    }
}
