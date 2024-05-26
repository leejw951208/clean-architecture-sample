package com.example.hexagonalarchitecture.product.shared.mapper;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public List<ProductSave> fromStrings(List<String> names) {
        return names.stream()
                .map(name -> ProductSave.builder()
                        .name(name)
                        .build()
                )
                .toList();
    }

    @Override
    public List<Product> fromEntities(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(productEntity -> Product.builder()
                        .name(productEntity.getName())
                        .build()
                )
                .toList();
    }

    @Override
    public List<ProductEntity> fromProductSaves(List<ProductSave> productSaves) {
        return productSaves.stream()
                .map(productSave -> ProductEntity.builder()
                        .name(productSave.getName())
                        .build()
                )
                .toList();
    }

    @Override
    public List<ProductEntity> fromProducts(List<Product> products) {
        return products.stream()
                .map(product -> ProductEntity.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .build()
                )
                .toList();
    }
}
