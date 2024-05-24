package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.FindGuestOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.SaveGuestOrderPort;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
@RequiredArgsConstructor
public class GuestOrderEntityQueryAdapter implements FindGuestOrderPort {
    private final GuestOrderEntityRepository guestOrderEntityRepository;

    @Override
    public String findLastOrderNumber() {
        return guestOrderEntityRepository.findLastOrderNumber()
                .orElseGet(() -> LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "GA00000");
    }
}
