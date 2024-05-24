package com.example.hexagonalarchitecture.user.shared.mapper;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.domain.UserSave;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .createdDate(userEntity.getCreatedDate())
                .build();

    }

    @Override
    public UserSave toDomain(String name) {
        return UserSave.builder()
                .name(name)
                .build();
    }

    @Override
    public UserEntity toEntity(UserSave domain) {
        return UserEntity.builder()
                .name(domain.getName())
                .build();
    }

    @Override
    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .createdDate(user.getCreatedDate())
                .build();
    }
}
