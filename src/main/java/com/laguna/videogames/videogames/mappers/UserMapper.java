package com.laguna.videogames.videogames.mappers;

import com.laguna.videogames.videogames.dtos.UserDto.UserRequestDto;
import com.laguna.videogames.videogames.dtos.UserDto.UserResponseDto;

import com.laguna.videogames.videogames.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toResponse(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    public User toModel(UserRequestDto userDTO) {
        return new User(
                null,
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
    }
}
