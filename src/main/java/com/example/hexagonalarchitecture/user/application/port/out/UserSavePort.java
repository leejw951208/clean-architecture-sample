package com.example.hexagonalarchitecture.user.application.port.out;

import com.example.hexagonalarchitecture.user.domain.UserSave;

public interface UserSavePort {
    void save(UserSave user);
}
