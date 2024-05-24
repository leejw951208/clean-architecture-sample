package com.example.hexagonalarchitecture.guest.shared.mapper;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;
import org.springframework.stereotype.Component;

@Component
public class GuestMapperImpl implements GuestMapper {
    @Override
    public Guest toDomain(GuestEntity entity) {
        return Guest.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public GuestSave toDomain(String name) {
        return GuestSave.builder()
                .name(name)
                .build();
    }

    @Override
    public GuestEntity toEntity(GuestSave domain) {
        return GuestEntity.builder()
                .name(domain.getName())
                .build();
    }
}
