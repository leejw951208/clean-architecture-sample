package com.example.cleanarchitecturesample.user.service;

import com.example.cleanarchitecturesample.user.domain.User;
import com.example.cleanarchitecturesample.user.domain.UserSave;
import com.example.cleanarchitecturesample.user.dto.UserFindDto;
import com.example.cleanarchitecturesample.user.dto.UserSaveDto;
import com.example.cleanarchitecturesample.user.mapper.UserMapper;
import com.example.cleanarchitecturesample.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public void save(UserSaveDto userSaveDto) {
        UserSave userSave = userMapper.toUserSave(userSaveDto);
        userRepository.save(userSave);
    }

    public UserFindDto findById(Long id) {
        return userMapper.toUserFindDto(userRepository.findById(id));
    }
}
