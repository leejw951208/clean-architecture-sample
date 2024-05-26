package com.example.hexagonalarchitecture.user.shared.mapper;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.domain.UserSave;

public interface UserMapper {
    User fromEntity(UserEntity userEntity);
    UserSave fromString(String name);
    UserEntity fromUserSave(UserSave domain);
    UserEntity fromUser(User user);
}
