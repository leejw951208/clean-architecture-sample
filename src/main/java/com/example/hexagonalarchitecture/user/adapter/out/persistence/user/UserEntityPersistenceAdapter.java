package com.example.hexagonalarchitecture.user.adapter.out.persistence.user;

import com.example.hexagonalarchitecture.user.application.port.out.SaveUserPort;
import com.example.hexagonalarchitecture.user.application.port.out.FindUserPort;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class UserEntityPersistenceAdapter implements SaveUserPort, FindUserPort {
    private final UserEntityJpaRepository userEntityJpaRepository;
    private final UserEntityRepositoryCustom userEntityRepositoryCustom;
    private final UserMapper userMapper;

    @Override
    public void save(User user) {
        UserEntity createdEntity = userMapper.toEntity(user);
        userEntityJpaRepository.save(createdEntity);
    }

    @Override
    public User findById(Long id) {
        UserEntity findEntity = userEntityRepositoryCustom.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return userMapper.toDomain(findEntity);
    }
}
