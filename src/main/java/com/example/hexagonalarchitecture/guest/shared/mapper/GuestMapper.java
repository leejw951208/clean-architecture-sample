package com.example.hexagonalarchitecture.guest.shared.mapper;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;

public interface GuestMapper {
    Guest fromEntity(GuestEntity guestEntity);
    GuestSave fromString(String name);
    GuestEntity fromGuestSave(GuestSave guestSave);
    GuestEntity fromGuest(Guest guest);
}
