package com.example.hexagonalarchitecture.product.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String productName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private LocalDateTime createdDate;

    @JsonIgnore
    private Long orderId;
}
