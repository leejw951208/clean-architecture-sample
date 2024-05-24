package com.example.hexagonalarchitecture.user.application.port.in;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;

public interface CreateUserUseCase {
    void createUser(String name);
}
