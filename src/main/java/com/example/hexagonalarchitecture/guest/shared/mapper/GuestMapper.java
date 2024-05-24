package com.example.hexagonalarchitecture.guest.shared.mapper;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;

public interface GuestMapper {
    Guest toDomain(GuestEntity entity);
    GuestSave toDomain(String name);
    GuestEntity toEntity(GuestSave domain);
    GuestEntity toEntity(Guest domain);
}
