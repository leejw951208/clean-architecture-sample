package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.guest.application.port.out.SaveGuestPort;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;
import com.example.hexagonalarchitecture.guest.shared.mapper.GuestMapper;
import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import com.example.hexagonalarchitecture.order.application.port.out.FindGuestOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.FindUserOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.SaveGuestOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.SaveUserOrderPort;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import com.example.hexagonalarchitecture.order.domain.user.UserOrderCommand;
import com.example.hexagonalarchitecture.order.shared.mapper.guest.GuestOrderMapper;
import com.example.hexagonalarchitecture.order.shared.mapper.user.UserOrderMapper;
import com.example.hexagonalarchitecture.order.shared.util.GeneratedOrderNumber;
import com.example.hexagonalarchitecture.product.application.port.out.FindProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.application.port.out.FindUserPort;
import com.example.hexagonalarchitecture.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {
    private final FindProductPort findProductPort;
    private final FindUserPort findUserPort;
    private final FindUserOrderPort findUserOrderPort;
    private final FindGuestOrderPort findGuestOrderPort;
    private final SaveGuestPort saveGuestPort;
    private final SaveGuestOrderPort saveGuestOrderPort;
    private final SaveUserOrderPort saveUserOrderPort;

    private final UserOrderMapper userOrderMapper;
    private final GuestMapper guestMapper;
    private final GuestOrderMapper guestOrderMapper;

    private final GeneratedOrderNumber generatedOrderNumber;

    @Override
    public void createUserOrder(long userId, List<Long> productIds) {
        User user = findUserPort.findById(userId);
        List<Product> products = findProductPort.findByIdIn(productIds);
        String orderNumber = findUserOrderPort.findLastOrderNumber();
        String generatedOrderNumber = this.generatedOrderNumber.generate(orderNumber);
        UserOrderCommand userOrderCommand = userOrderMapper.toDomain(user, generatedOrderNumber, products);
        saveUserOrderPort.save(userOrderCommand);
    }

    @Override
    @Transactional
    public void createGuestOrder(String name, List<Long> productIds) {
        GuestSave guestSave = guestMapper.toDomain(name);
        Guest guest = saveGuestPort.save(guestSave);
        List<Product> products = findProductPort.findByIdIn(productIds);
        String orderNumber = findGuestOrderPort.findLastOrderNumber();
        String generatedOrderNumber = this.generatedOrderNumber.generate(orderNumber);
        GuestOrderCommand guestOrderCommand = guestOrderMapper.toDomain(guest, generatedOrderNumber, products);
        saveGuestOrderPort.save(guestOrderCommand);
    }
}
