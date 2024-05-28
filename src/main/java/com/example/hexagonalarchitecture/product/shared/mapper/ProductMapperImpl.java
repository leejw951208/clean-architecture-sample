package com.example.hexagonalarchitecture.product.shared.mapper;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductFindDto;
import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductSave fromString(String name) {
        return ProductSave.builder()
                .name(name)
                .build();
    }

    @Override
    public List<Product> fromEntities(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(productEntity -> Product.builder()
                        .id(productEntity.getId())
                        .name(productEntity.getName())
                        .createdDate(productEntity.getCreatedDate())
                        .build()
                )
                .toList();
    }

    @Override
    public Product fromEntity(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .createdDate(productEntity.getCreatedDate())
                .build();
    }

    @Override
    public ProductUpdate fromProductToProductUpdate(Product product) {
        return ProductUpdate.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }

    @Override
    public ProductEntity fromProductSave(ProductSave productSave) {
        return ProductEntity.builder()
                .name(productSave.getName())
                .build();
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

    @Override
    public ProductEntity fromProductUpdate(ProductUpdate productUpdate) {
        return ProductEntity.builder()
                .id(productUpdate.getId())
                .name(productUpdate.getName())
                .build();
    }

    @Override
    public ProductFindDto fromProductToProductFindDto(Product product) {
        return ProductFindDto.builder()
                .id(product.getId())
                .name(product.getName())
                .createdDate(product.getCreatedDate())
                .build();
    }
}
