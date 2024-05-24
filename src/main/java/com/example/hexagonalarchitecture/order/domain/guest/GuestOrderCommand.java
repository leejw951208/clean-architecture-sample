package com.example.hexagonalarchitecture.order.domain.guest;

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
public class GuestOrderCommand {
    private Guest guest;
    private List<Product> products;
}
