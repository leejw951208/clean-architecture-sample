package com.example.hexagonalarchitecture.product.controller;

import com.example.hexagonalarchitecture.product.adapter.in.web.ProductCommandController;
import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.command.ProductEntityCommandAdapter;
import com.example.hexagonalarchitecture.product.application.port.in.ProductSaveUseCases;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductCommandController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class ProductTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductSaveUseCases productSaveUseCases;

    @Test
    @DisplayName("상품 다건 저장")
    public void saveProductsTest() throws Exception {
        // given
        List<ProductSaveDto> saveDtos = create();
        String content = objectMapper.writeValueAsString(saveDtos);

        List<String> names = new ArrayList<>();
        List<ProductSave> productSaves = new ArrayList<>();

        given(productMapper.fromStrings(names)).willReturn(productSaves);
        willDoNothing().given(productSaveUseCases).saveProducts(productSaves);

        // when
        ResultActions actions = mockMvc.perform(post("/api/products", 1)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                        .andDo(print());

        // then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("succeed"));
    }

    private List<ProductSaveDto> create() {
        return List.of(ProductSaveDto.builder().name("상품1").build(), ProductSaveDto.builder().name("상품2").build());
    }
}
