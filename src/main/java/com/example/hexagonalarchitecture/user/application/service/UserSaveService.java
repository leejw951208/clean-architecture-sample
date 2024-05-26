package com.example.hexagonalarchitecture.user.application.service;

import com.example.hexagonalarchitecture.user.application.port.in.UserSaveUseCases;
import com.example.hexagonalarchitecture.user.application.port.out.UserSavePort;
import com.example.hexagonalarchitecture.user.domain.UserSave;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSaveService implements UserSaveUseCases {
    private final UserSavePort userSavePort;
    private final UserMapper userMapper;

    @Override
    public void saveUser(String name) {
        UserSave createdDomain = userMapper.fromString(name);
        userSavePort.save(createdDomain);
    }
}
