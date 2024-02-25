package com.laguna.videogames.videogames.controllers;

import com.laguna.videogames.videogames.dtos.UserDto.UserRequestDto;
import com.laguna.videogames.videogames.dtos.UserDto.UserResponseDto;
import com.laguna.videogames.videogames.mappers.UserMapper;
import com.laguna.videogames.videogames.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserDetailsServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.loadUserByUsername(email)));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> postUser(
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.save(userMapper.toModel(user))));
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable String email,
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.updateUser(email, userMapper.toModel(user))));
    }
}
