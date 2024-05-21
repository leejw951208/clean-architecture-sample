package com.example.hexagonalarchitecture.product.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Product {
    private Long id;
    private String productName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private LocalDateTime registrationDate;
}
