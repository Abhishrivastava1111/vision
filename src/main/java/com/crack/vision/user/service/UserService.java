package com.crack.vision.user.service;

import java.util.Optional;

import com.crack.vision.user.dto.UserDto;
import com.crack.vision.user.entity.User;

public interface UserService {

    String saveUser(UserDto userDto);

    Integer loginUser(String email, String password);

    void uploadDocument(Integer userId, String filePath, String description);

    Optional<User> getUserDetails(Integer userId);

    String editUser(Integer userId, UserDto userDto);
    
}
