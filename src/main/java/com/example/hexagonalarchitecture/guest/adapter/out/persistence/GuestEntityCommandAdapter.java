package com.example.hexagonalarchitecture.guest.adapter.out.persistence;

import com.example.hexagonalarchitecture.guest.application.port.out.GuestSavePort;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;
import com.example.hexagonalarchitecture.guest.shared.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GuestEntityCommandAdapter implements GuestSavePort {
    private final GuestEntityJpaRepository guestEntityJpaRepository;
    private final GuestMapper guestMapper;

    @Override
    public Guest save(GuestSave guestSave) {
        GuestEntity saved = guestEntityJpaRepository.save(guestMapper.fromGuestSave(guestSave));
        return guestMapper.fromEntity(saved);
    }
}
