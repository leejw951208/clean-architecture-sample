package com.example.hexagonalarchitecture.user.adapter.in.web;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.UserSaveDto;
import com.example.hexagonalarchitecture.user.application.port.in.UserSaveUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserCommandController {
    private final UserSaveUseCases createUserUseCase;

    @PostMapping("/api/user")
    public ResponseEntity<String> createUser(@RequestBody UserSaveDto dto) {
        createUserUseCase.saveUser(dto.getName());
        return ResponseEntity.ok("succeed");
    }
}
