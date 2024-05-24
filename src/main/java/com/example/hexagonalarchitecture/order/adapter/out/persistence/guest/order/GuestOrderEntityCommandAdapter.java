package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.shared.mapper.GuestMapper;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntityJpaRepository;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail.UserOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntity;
import com.example.hexagonalarchitecture.order.application.port.out.SaveGuestOrderPort;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import com.example.hexagonalarchitecture.order.shared.mapper.guest.GuestOrderMapper;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GuestOrderEntityCommandAdapter implements SaveGuestOrderPort {
    private final GuestOrderEntityJpaRepository guestOrderEntityJpaRepository;
    private final GuestOrderDetailEntityJpaRepository guestOrderDetailEntityJpaRepository;
    private final GuestMapper guestMapper;
    private final GuestOrderMapper guestOrderMapper;
    private final ProductMapper productMapper;

    @Override
    public void save(GuestOrderCommand domain) {
        GuestEntity guest = guestMapper.toEntity(domain.getGuest());
        GuestOrderEntity guestOrder = guestOrderMapper.toEntity(guest, domain.getOrderNumber());
        GuestOrderEntity savedGuestOrder = guestOrderEntityJpaRepository.save(guestOrder);

        List<ProductEntity> products = productMapper.toEntity(domain.getProducts());
        List<GuestOrderDetailEntity> guestOrderDetails = guestOrderMapper.toEntity(savedGuestOrder, products);
        guestOrderDetailEntityJpaRepository.saveAll(guestOrderDetails);
    }
}
