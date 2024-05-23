package com.example.hexagonalarchitecture.order.adapter.out.persistence.order.query;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntityRepositoryCustom;
import com.example.hexagonalarchitecture.order.application.port.out.FindOrderPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class OrderEntityQueryAdapter implements FindOrderPort {
    private final OrderEntityRepositoryCustom orderEntityRepositoryCustom;

    @Override
    public List<Order> findByUserId(long userId) {
        return orderEntityRepositoryCustom.findDomainByUserId(userId);
    }

    @Override
    public Order findByUserIdAndId(long userId, long id) {
        return orderEntityRepositoryCustom.findDomainByUserIdAndId(userId, id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order findByOrderNo(String orderNo) {
        return orderEntityRepositoryCustom.findDomainByOrderNo(orderNo).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Product> findProductsById(long id) {
        return orderEntityRepositoryCustom.findProductsById(id);
    }

    @Override
    public List<Product> findProductsByIdIn(List<Long> ids) {
        return orderEntityRepositoryCustom.findProductsByIdIn(ids);
    }
}
