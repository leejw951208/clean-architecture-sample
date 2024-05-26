package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.query;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.GuestOrderEntityRepository;
import com.example.hexagonalarchitecture.order.application.port.out.GuestOrderFindPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
@RequiredArgsConstructor
public class GuestOrderEntityQueryAdapter implements GuestOrderFindPort {
    private final GuestOrderEntityRepository guestOrderEntityRepository;

    @Override
    public String findLastOrderNumber() {
        return guestOrderEntityRepository.findLastOrderNumber()
                .orElseGet(() -> LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "GA00000");
    }

    @Override
    public Order findByOrderNumber(String orderNumber) {
        return null;
    }
}
