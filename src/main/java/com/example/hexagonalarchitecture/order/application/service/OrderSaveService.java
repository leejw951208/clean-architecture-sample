package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.guest.application.port.out.GuestSavePort;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;
import com.example.hexagonalarchitecture.guest.shared.mapper.GuestMapper;
import com.example.hexagonalarchitecture.order.application.port.in.OrderSaveUseCases;
import com.example.hexagonalarchitecture.order.application.port.out.GuestOrderFindPort;
import com.example.hexagonalarchitecture.order.application.port.out.UserOrderFindPort;
import com.example.hexagonalarchitecture.order.application.port.out.GuestOrderSavePort;
import com.example.hexagonalarchitecture.order.application.port.out.UserOrderSavePort;
import com.example.hexagonalarchitecture.order.domain.GuestOrderSave;
import com.example.hexagonalarchitecture.order.domain.UserOrderSave;
import com.example.hexagonalarchitecture.order.shared.mapper.guest.GuestOrderMapper;
import com.example.hexagonalarchitecture.order.shared.mapper.user.UserOrderMapper;
import com.example.hexagonalarchitecture.order.shared.util.GeneratedOrderNumber;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.application.port.out.UserFindPort;
import com.example.hexagonalarchitecture.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSaveService implements OrderSaveUseCases {
    private final ProductFindPort productFindPort;
    private final UserFindPort userFindPort;
    private final UserOrderFindPort userOrderFindPort;
    private final GuestOrderFindPort guestOrderFindPort;
    private final GuestSavePort guestSavePort;
    private final GuestOrderSavePort guestOrderSavePort;
    private final UserOrderSavePort userOrderSavePort;

    private final UserOrderMapper userOrderMapper;
    private final GuestMapper guestMapper;
    private final GuestOrderMapper guestOrderMapper;

    private final GeneratedOrderNumber generatedOrderNumber;

    @Override
    public void createOrder(long userId, List<Long> productIds) {
        User user = userFindPort.findById(userId);
        List<Product> products = productFindPort.findByIds(productIds);
        String orderNumber = userOrderFindPort.findLastOrderNumber();
        String newOrderNumber = generatedOrderNumber.generate(orderNumber);
        UserOrderSave userOrderCommand = userOrderMapper.fromArgs(user, newOrderNumber, products);
        userOrderSavePort.saveUserOrder(userOrderCommand);
    }

    @Override
    @Transactional
    public void createOrder(String name, List<Long> productIds) {
        GuestSave guestSave = guestMapper.fromString(name);
        Guest guest = guestSavePort.save(guestSave);
        List<Product> products = productFindPort.findByIds(productIds);
        String orderNumber = guestOrderFindPort.findLastOrderNumber();
        String newOrderNumber = generatedOrderNumber.generate(orderNumber);
        GuestOrderSave guestOrderCommand = guestOrderMapper.fromArgs(guest, newOrderNumber, products);
        guestOrderSavePort.save(guestOrderCommand);
    }
}
