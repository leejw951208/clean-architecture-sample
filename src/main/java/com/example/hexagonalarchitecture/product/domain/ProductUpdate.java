package com.example.hexagonalarchitecture.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdate {
    private Long id;
    private String name;

    public void updateName(String name) {
        this.name = name;
    }
}
