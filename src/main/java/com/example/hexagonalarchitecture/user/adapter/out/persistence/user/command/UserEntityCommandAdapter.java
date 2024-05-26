package com.example.hexagonalarchitecture.user.adapter.out.persistence.user.command;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntityJpaRepository;
import com.example.hexagonalarchitecture.user.application.port.out.UserSavePort;
import com.example.hexagonalarchitecture.user.domain.UserSave;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserEntityCommandAdapter implements UserSavePort {
    private final UserEntityJpaRepository userEntityJpaRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserSave user) {
        UserEntity createdEntity = userMapper.fromUserSave(user);
        userEntityJpaRepository.save(createdEntity);
    }
}
