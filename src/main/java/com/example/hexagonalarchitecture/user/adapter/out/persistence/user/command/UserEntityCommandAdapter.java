package com.example.hexagonalarchitecture.user.adapter.out.persistence.user.command;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntityJpaRepository;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntityRepositoryCustom;
import com.example.hexagonalarchitecture.user.application.port.out.FindUserPort;
import com.example.hexagonalarchitecture.user.application.port.out.SaveUserPort;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.domain.UserSave;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class UserEntityCommandAdapter implements SaveUserPort {
    private final UserEntityJpaRepository userEntityJpaRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserSave user) {
        UserEntity createdEntity = userMapper.toEntity(user);
        userEntityJpaRepository.save(createdEntity);
    }
}
