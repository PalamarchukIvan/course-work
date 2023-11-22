package org.example.mapper;

import org.example.dto.UserDto;
import org.example.model.User;

import java.io.IOException;

public class UserMapper {
    public static User fromDtoReg(UserDto userDto) throws IOException {
        return User.builder()
                .photo(userDto.getPhoto().getBytes())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
}
