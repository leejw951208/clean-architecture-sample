package com.example.cleanarchitecturesample.user.repository;

import com.example.cleanarchitecturesample.user.domain.User;
import com.example.cleanarchitecturesample.user.domain.UserSave;
import com.example.cleanarchitecturesample.user.mapper.UserMapper;
import com.example.cleanarchitecturesample.user.persistence.UserEntity;
import com.example.cleanarchitecturesample.user.persistence.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;
    private final UserEntityRepository userEntityRepository;

    @Override
    public void save(UserSave user) {
        userEntityRepository.save(userMapper.toUserEntity(user));
    }

    @Override
    public User findById(long id) {
        UserEntity findUserEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return userMapper.toUser(findUserEntity);
    }
}
