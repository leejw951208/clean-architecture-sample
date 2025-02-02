package com.example.cleanarchitecturesample.user.controller;

import com.example.cleanarchitecturesample.user.dto.UserFindDto;
import com.example.cleanarchitecturesample.user.dto.UserSaveDto;
import com.example.cleanarchitecturesample.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserSaveDto dto) {
        userService.save(dto);
        return ResponseEntity.ok("succeed");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserFindDto> findUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
