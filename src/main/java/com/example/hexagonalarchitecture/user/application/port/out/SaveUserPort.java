package com.example.hexagonalarchitecture.user.application.port.out;

import com.example.hexagonalarchitecture.user.domain.User;

public interface SaveUserPort {
    void save(User user);
}
