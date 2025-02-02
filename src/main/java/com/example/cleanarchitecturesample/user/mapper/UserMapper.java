package com.example.cleanarchitecturesample.user.mapper;

import com.example.cleanarchitecturesample.user.dto.UserFindDto;
import com.example.cleanarchitecturesample.user.dto.UserSaveDto;
import com.example.cleanarchitecturesample.user.persistence.UserEntity;
import com.example.cleanarchitecturesample.user.domain.User;
import com.example.cleanarchitecturesample.user.domain.UserSave;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserSave toUserSave(UserSaveDto dto);
    UserEntity toUserEntity(UserSave userSave);
    User toUser(UserEntity entity);
    UserFindDto toUserFindDto(User user);
}
