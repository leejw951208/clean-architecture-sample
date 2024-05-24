package com.example.hexagonalarchitecture.guest.application.port.out;

import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.guest.domain.GuestSave;

public interface SaveGuestPort {
    Guest save(GuestSave domain);
}
