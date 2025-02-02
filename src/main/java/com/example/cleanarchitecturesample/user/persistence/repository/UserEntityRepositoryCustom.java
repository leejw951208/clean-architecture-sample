package com.example.cleanarchitecturesample.user.persistence.repository;

import com.example.cleanarchitecturesample.user.persistence.UserEntity;

import java.util.Optional;

public interface UserEntityRepositoryCustom {
    Optional<UserEntity> findById(long id);
}
