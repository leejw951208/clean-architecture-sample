package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.customer.application.port.out.SaveCustomerPort;
import com.example.hexagonalarchitecture.customer.domain.Customer;
import com.example.hexagonalarchitecture.customer.shared.mapper.CustomerMapper;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateGuestOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateUserOrderRequestDto;
import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import com.example.hexagonalarchitecture.order.application.port.out.SaveOrderPort;
import com.example.hexagonalarchitecture.order.domain.CommandOrder;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.application.port.out.FindProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.application.port.out.FindUserPort;
import com.example.hexagonalarchitecture.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {
    private final FindProductPort findProductPort;
    private final FindUserPort findUserPort;
    private final SaveOrderPort saveOrderPort;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;

    @Override
    public void createOrder(CreateUserOrderRequestDto dto) {
        User findUser = findUserPort.findById(dto.getUserId());
        CommandOrder createdOrder = create(findUser.getName(), dto.getProductIds(), 1);
        saveOrderPort.save(createdOrder, findUser);
    }

    @Override
    public void createOrder(CreateGuestOrderRequestDto dto) {
        CommandOrder createdOrder = create(dto.getCustomerName(), dto.getProductIds(), 2);
        saveOrderPort.save(createdOrder);
    }

    private CommandOrder create(String name, List<Long> productIds, int isUser) {
        Customer createdCustomer = customerMapper.toDomain(name, isUser);
        List<Product> findProducts = findProductPort.findByIdIn(productIds);
        return orderMapper.toDomain(createdCustomer, findProducts);
    }
}
