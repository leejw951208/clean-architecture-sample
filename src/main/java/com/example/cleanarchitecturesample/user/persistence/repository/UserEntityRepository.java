package com.example.cleanarchitecturesample.user.persistence.repository;

import com.example.cleanarchitecturesample.user.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
