package com.example.hexagonalarchitecture.product.shared.mapper;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;

import java.util.List;

public interface ProductMapper {
    List<ProductSave> fromStrings(List<String> name);
    List<Product> fromEntities(List<ProductEntity> productEntities);
    List<ProductEntity> fromProductSaves(List<ProductSave> productSaves);
    List<ProductEntity> fromProducts(List<Product> products);
}
