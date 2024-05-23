package com.example.hexagonalarchitecture.user.shared.mapper;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;

public interface UserMapper {
    UserEntity toEntity(User user);
    UserEntity toEntityWithId(User user);
    User toDomainWithId(UserEntity userEntity);
    User toDomainWithId(CreateUserRequestDto dto);
}
