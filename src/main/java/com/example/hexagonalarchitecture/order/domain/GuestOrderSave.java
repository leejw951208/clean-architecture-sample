package com.example.hexagonalarchitecture.order.domain;

import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestOrderSave {
    private Guest guest;
    private String orderNumber;
    private List<Product> products;
}
