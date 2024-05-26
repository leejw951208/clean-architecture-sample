package com.example.hexagonalarchitecture.user.shared.mapper;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.domain.UserSave;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User fromEntity(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .createdDate(userEntity.getCreatedDate())
                .build();

    }

    @Override
    public UserSave fromString(String name) {
        return UserSave.builder()
                .name(name)
                .build();
    }

    @Override
    public UserEntity fromUserSave(UserSave domain) {
        return UserEntity.builder()
                .name(domain.getName())
                .build();
    }

    @Override
    public UserEntity fromUser(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .createdDate(user.getCreatedDate())
                .build();
    }
}
