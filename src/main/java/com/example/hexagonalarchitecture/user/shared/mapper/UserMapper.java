package com.example.hexagonalarchitecture.user.shared.mapper;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.domain.UserSave;

public interface UserMapper {
    User toDomain(UserEntity userEntity);
    UserSave toDomain(String name);
    UserEntity toEntity(UserSave domain);
    UserEntity toEntity(User user);
}
