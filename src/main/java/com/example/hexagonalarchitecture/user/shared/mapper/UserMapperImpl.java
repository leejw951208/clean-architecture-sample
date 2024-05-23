package com.example.hexagonalarchitecture.user.shared.mapper;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .build();
    }

    @Override
    public UserEntity toEntityWithId(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Override
    public User toDomainWithId(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .createdDate(userEntity.getCreatedDate())
                .build();

    }

    @Override
    public User toDomainWithId(CreateUserRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .build();
    }
}
