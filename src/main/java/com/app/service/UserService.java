package com.app.service;
import com.app.model.User;
import com.app.service.dto.UserDto;
import jakarta.validation.Valid;

public interface UserService {
     User findUserByEmailOrPhone(String emailOrPhone);

    UserDto getUserById(Long id);

    UserDto registerUser(UserDto requestDto);
}
