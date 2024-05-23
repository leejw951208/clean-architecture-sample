package com.example.hexagonalarchitecture.user.application.service;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.application.port.in.CreateUserUseCase;
import com.example.hexagonalarchitecture.user.application.port.out.SaveUserPort;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final SaveUserPort createUserPort;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUserRequestDto dto) {
        User createdDomain = userMapper.toDomainWithId(dto);
        createUserPort.save(createdDomain);
    }
}
