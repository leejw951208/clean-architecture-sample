package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import com.example.hexagonalarchitecture.order.application.port.out.FindUserOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
@RequiredArgsConstructor
public class UserOrderEntityQueryAdapter implements FindUserOrderPort {
    private final UserOrderEntityRepository userOrderEntityRepository;

    @Override
    public String findLastOrderNumber() {
        return userOrderEntityRepository.findLastOrderNumber()
                .orElseGet(() -> LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "UA00000");
    }
}
