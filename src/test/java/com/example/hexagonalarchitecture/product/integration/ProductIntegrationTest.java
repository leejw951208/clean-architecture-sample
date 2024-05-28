package com.example.hexagonalarchitecture.product.integration;

import com.example.hexagonalarchitecture.base.BaseIntegrationTest;
import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private ProductSetUp productSetUp;

    @Test
    @DisplayName("통합테스트: 상품 등록")
    public void saveProduct() throws Exception {
        // given
        String name = "product1";
        ProductSaveDto dto = ProductSaveDto.builder().name(name).build();
        String requestContent = objectMapper.writeValueAsString(dto);

        // when
        ResultActions actions = mockMvc.perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestContent))
                .andDo(print());

        // then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("succeed"));
    }

    @Test
    @DisplayName("통합테스트: 상품 조회")
    public void findProduct() throws Exception {
        // given
        String name = "product1";
        Long savedId = productSetUp.saveProduct(name);

        // when
        ResultActions actions = mockMvc.perform(get("/api/product/{id}", savedId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("name").value(name));
    }

    @Test
    @DisplayName("통합테스트: 상품명 수정")
    public void updateProductName() throws Exception {
        // given
        String name = "product1";
        Long savedId = productSetUp.saveProduct(name);
        String updateName = "goods1";
        ProductSaveDto dto = ProductSaveDto.builder().name(updateName).build();
        String request = objectMapper.writeValueAsString(dto);

        // when
        ResultActions actions = mockMvc.perform(put("/api/product/{id}", savedId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print());

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$").value("succeed"));
    }
}
