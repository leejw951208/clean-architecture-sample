package com.example.hexagonalarchitecture.user.adapter.in.web;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.application.port.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandUserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/api/user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequestDto dto) {
        createUserUseCase.createUser(dto.getName());
        return ResponseEntity.ok("succeed");
    }
}
