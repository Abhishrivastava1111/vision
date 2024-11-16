package com.crack.vision.user.service;

import com.crack.vision.user.dto.UserDto;

public interface UserService {

    String saveUser(UserDto userDto);

    Integer loginUser(String email, String password);
}
