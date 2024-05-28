package com.example.hexagonalarchitecture.product.unit;

import com.example.hexagonalarchitecture.config.JpaAuditingConfig;
import com.example.hexagonalarchitecture.base.BaseUnitTest;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaAuditingConfig.class)
public class ProductRepositoryTest extends BaseUnitTest {
    @Autowired
    private ProductEntityJpaRepository productEntityJpaRepository;

    @Test
    @DisplayName("리포지토리 단위테스트: 상품 저장")
    public void saveProduct() {
        // given
        ProductEntity newProduct = ProductEntity.builder().name("product1").build();

        // when
        ProductEntity savedProduct = productEntityJpaRepository.save(newProduct);

        // then
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo(newProduct.getName());
    }

    @Test
    @DisplayName("리포지토리 단위테스트: 상품 조회")
    public void findProduct() {
        // given
        ProductEntity newProduct = ProductEntity.builder().name("product1").build();
        ProductEntity savedProduct = productEntityJpaRepository.save(newProduct);

        // when
        ProductEntity findProduct = productEntityJpaRepository.findById(savedProduct.getId())
                .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다."));

        // then
        assertThat(findProduct).isNotNull();
        assertThat(findProduct.getName()).isEqualTo(savedProduct.getName());
    }

    @Test
    @DisplayName("리포지토리 단위테스트: 상품명 수정")
    public void updateProductName() {
        // given
        String updateName = "goods1";
        ProductEntity newProduct = ProductEntity.builder().name("product1").build();
        ProductEntity savedProduct = productEntityJpaRepository.save(newProduct);

        // when
        savedProduct.updateName(updateName);

        // then
        ProductEntity findProduct = productEntityJpaRepository.findById(savedProduct.getId())
                .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다."));

        assertThat(findProduct).isNotNull();
        assertThat(findProduct.getName()).isEqualTo(updateName);
    }
}
