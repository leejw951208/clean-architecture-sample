package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.command;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.shared.mapper.GuestMapper;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntityJpaRepository;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.GuestOrderEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.GuestOrderEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.GuestOrderSavePort;
import com.example.hexagonalarchitecture.order.domain.GuestOrderSave;
import com.example.hexagonalarchitecture.order.shared.mapper.guest.GuestOrderMapper;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GuestOrderEntityCommandAdapter implements GuestOrderSavePort {
    private final GuestOrderEntityJpaRepository guestOrderEntityJpaRepository;
    private final GuestOrderDetailEntityJpaRepository guestOrderDetailEntityJpaRepository;
    private final GuestMapper guestMapper;
    private final GuestOrderMapper guestOrderMapper;
    private final ProductMapper productMapper;

    @Override
    public void save(GuestOrderSave domain) {
        GuestEntity guest = guestMapper.fromGuest(domain.getGuest());
        GuestOrderEntity guestOrder = guestOrderMapper.fromArgs(guest, domain.getOrderNumber());
        GuestOrderEntity savedGuestOrder = guestOrderEntityJpaRepository.save(guestOrder);

        List<ProductEntity> products = productMapper.fromProducts(domain.getProducts());
        List<GuestOrderDetailEntity> guestOrderDetails = guestOrderMapper.fromArgs(savedGuestOrder, products);
        guestOrderDetailEntityJpaRepository.saveAll(guestOrderDetails);
    }
}
