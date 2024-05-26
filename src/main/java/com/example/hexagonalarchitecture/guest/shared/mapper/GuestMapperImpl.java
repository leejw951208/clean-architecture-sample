package com.example.hexagonalarchitecture.guest.shared.mapper;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;
import org.springframework.stereotype.Component;

@Component
public class GuestMapperImpl implements GuestMapper {
    @Override
    public Guest fromEntity(GuestEntity guestEntity) {
        return Guest.builder()
                .id(guestEntity.getId())
                .name(guestEntity.getName())
                .build();
    }

    @Override
    public GuestSave fromString(String name) {
        return new GuestSave(name);
    }

    @Override
    public GuestEntity fromGuestSave(GuestSave guestSave) {
        return GuestEntity.builder()
                .name(guestSave.getName())
                .build();
    }

    @Override
    public GuestEntity fromGuest(Guest guest) {
        return GuestEntity.builder()
                .id(guest.getId())
                .name(guest.getName())
                .build();
    }
}
