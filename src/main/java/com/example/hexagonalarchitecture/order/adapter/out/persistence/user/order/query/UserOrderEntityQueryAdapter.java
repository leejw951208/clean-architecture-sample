package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.query;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntityRepository;
import com.example.hexagonalarchitecture.order.application.port.out.UserOrderFindPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.user.UserOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class UserOrderEntityQueryAdapter implements UserOrderFindPort {
    private final UserOrderEntityRepository userOrderEntityRepository;
    private final UserOrderMapper userOrderMapper;

    @Override
    public String findLastOrderNumber() {
        return userOrderEntityRepository.findLastOrderNumber()
                .orElseGet(() -> LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "UA00000");
    }

    @Override
    public Order findOrder(long orderId) {
        return userOrderEntityRepository.findByOrderId(orderId)
                .orElseThrow(() -> new NoSuchElementException("주문정보를 찾을 수 없습니다."));
    }
}
