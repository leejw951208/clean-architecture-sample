package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.OrderResponseDto;
import com.example.hexagonalarchitecture.order.application.port.out.FindOrderPort;
import com.example.hexagonalarchitecture.order.application.port.in.TrackOrderUseCase;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackOrderService implements TrackOrderUseCase {
    private final FindOrderPort findOrderPort;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponseDto> trackOrders(long userId) {
        List<Order> orders = findOrderPort.findByUserId(userId);
        List<Long> orderIds = orders.stream().map(Order::getId).toList();
        List<Product> products = findOrderPort.findProductsByIdIn(orderIds);

        Map<Long, List<Product>> productMap = products.stream()
                .collect(Collectors.groupingBy(Product::getOrderId, Collectors.mapping(x1 -> x1, Collectors.toList())));
        orders.forEach(order -> order.setProducts(productMap));

        return orderMapper.toDtos(orders);
    }

    @Override
    public OrderResponseDto trackOrder(long userId, long id) {
        Order order = findOrderPort.findByUserIdAndId(userId, id);
        List<Product> products = findOrderPort.findProductsById(order.getId());
        return orderMapper.toDto(order, products);
    }

    @Override
    public OrderResponseDto trackOrder(String orderNo) {
        Order order = findOrderPort.findByOrderNo(orderNo);
        List<Product> products = findOrderPort.findProductsById(order.getId());
        return orderMapper.toDto(order, products);
    }
}
