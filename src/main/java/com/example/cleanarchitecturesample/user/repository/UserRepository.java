package com.example.cleanarchitecturesample.user.repository;

import com.example.cleanarchitecturesample.user.domain.User;
import com.example.cleanarchitecturesample.user.domain.UserSave;

public interface UserRepository {
    void save(UserSave user);
    User findById(long id);
}
