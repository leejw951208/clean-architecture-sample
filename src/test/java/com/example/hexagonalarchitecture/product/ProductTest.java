package com.example.hexagonalarchitecture.product;

import com.example.hexagonalarchitecture.product.adapter.in.web.ProductCommandController;
import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
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

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductCommandController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class ProductTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductSaveUseCases productSaveUseCases;

    @MockBean
    private ProductMapper productMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("상품 다건 저장")
    public void saveProductsTest() throws Exception {
        // given
        List<ProductSaveDto> saveDtos = List.of(
                ProductSaveDto.builder().name("product1").build(),
                ProductSaveDto.builder().name("product2").build()
        );
        String content = objectMapper.writeValueAsString(saveDtos);
        List<ProductSave> productSaves = saveDtos.stream().map(dto -> ProductSave.builder().name(dto.getName()).build()).toList();
        List<Product> products = List.of(
                Product.builder().id(1L).name("product1").build(),
                Product.builder().id(2L).name("product2").build()
        );

        given(productMapper.fromStrings(anyList())).willReturn(productSaves);
        given(productSaveUseCases.saveProducts(productSaves)).willReturn(products);

        // when
        ResultActions actions = mockMvc.perform(
                post("/api/products", 1)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        // then
        actions.andExpect(status().isCreated());
        for (int i = 0; i < products.size(); i++) {
            actions.andExpect(jsonPath("$[" + i + "].name").value(products.get(i).getName()));
        }
    }
}
