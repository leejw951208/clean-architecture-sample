package com.example.hexagonalarchitecture.user.application.port.out;

import com.example.hexagonalarchitecture.user.domain.User;

import java.util.Optional;

public interface FindUserPort {
    User findById(long id);
}
