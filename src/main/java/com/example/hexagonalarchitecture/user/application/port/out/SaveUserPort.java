package com.example.hexagonalarchitecture.user.application.port.out;

import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.domain.UserSave;

public interface SaveUserPort {
    void save(UserSave user);
}
