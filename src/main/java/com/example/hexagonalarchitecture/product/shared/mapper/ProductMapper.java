package com.example.hexagonalarchitecture.product.shared.mapper;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductFindDto;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;

import java.util.List;

public interface ProductMapper {
    ProductSave fromString(String name);
    List<Product> fromEntities(List<ProductEntity> productEntities);
    Product fromEntity(ProductEntity productEntity);
    ProductUpdate fromProductToProductUpdate(Product product);
    ProductEntity fromProductSave(ProductSave productSave);
    List<ProductEntity> fromProducts(List<Product> products);
    ProductEntity fromProductUpdate(ProductUpdate productUpdate);
    ProductFindDto fromProductToProductFindDto(Product product);
}
