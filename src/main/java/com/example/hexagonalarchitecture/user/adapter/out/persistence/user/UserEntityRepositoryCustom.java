package com.example.hexagonalarchitecture.user.adapter.out.persistence.user;

import java.util.Optional;

public interface UserEntityRepositoryCustom {
    Optional<UserEntity> findById(long id);
}
