package com.example.hexagonalarchitecture.product.repository;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ProductTest {
    @Autowired
    private ProductEntityJpaRepository productEntityJpaRepository;

    @Test
    @DisplayName("리포지토리 단위테스트: 상품 저장")
    public void saveProduct() {
        // given
        ProductEntity newProduct = ProductEntity.builder().name("product1").build();
        ProductEntity saved = productEntityJpaRepository.save(newProduct);

        // when
        Optional<ProductEntity> findProduct = productEntityJpaRepository.findById(saved.getId());

        // then
        assertThat(findProduct).isNotEmpty();
        assertThat(findProduct.get().getName()).isEqualTo("product1");
    }

    @Test
    @DisplayName("리포지토리 단위테스트: 상품명 수정")
    public void updateProductName() {
        // given
        String updateName = "goods1";
        ProductEntity newProduct = ProductEntity.builder().name("product1").build();
        ProductEntity saved = productEntityJpaRepository.save(newProduct);

        // when
        saved.updateName(updateName);

        // then
        ProductEntity findProduct = productEntityJpaRepository.findById(saved.getId()).get();
        assertThat(findProduct.getName()).isEqualTo(updateName);
    }
}
