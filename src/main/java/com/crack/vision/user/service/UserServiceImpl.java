package com.crack.vision.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.crack.vision.user.dao.RoleDao;
import com.crack.vision.user.dao.UserDao;
import com.crack.vision.user.dto.UserDto;
import com.crack.vision.user.entity.Role;
import com.crack.vision.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final RoleDao roleDao;

    private final ModelMapper modelMapper;

    public String saveUser(UserDto userDto) {

        Optional<Role> optionalRole = roleDao.getRoleById(userDto.getRole());
        if (optionalRole.isPresent()) {
            User user = modelMapper.map(userDto, User.class);
            user.setRole(optionalRole.get());
            userDao.saveUser(user);
            return "User saved successfully";

        } else {
            throw new RuntimeException();
        }

    }
}
