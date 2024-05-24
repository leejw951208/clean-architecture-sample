package com.example.hexagonalarchitecture.user.adapter.out.persistence.user.query;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntityRepositoryCustom;
import com.example.hexagonalarchitecture.user.application.port.out.FindUserPort;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class UserEntityQueryAdapter implements FindUserPort {
    private final UserEntityRepositoryCustom userEntityRepositoryCustom;
    private final UserMapper userMapper;

    @Override
    public User findById(long id) {
        UserEntity entity = userEntityRepositoryCustom.findById(id).orElseThrow(NoSuchElementException::new);
        return userMapper.toDomain(entity);
    }
}
