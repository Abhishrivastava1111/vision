
package com.crack.vision.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crack.vision.user.dao.RoleDao;
import com.crack.vision.user.dao.UserDao;
import com.crack.vision.user.dto.UserDto;
import com.crack.vision.user.entity.Role;
import com.crack.vision.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Component
@Configuration
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    
    private final RoleDao roleDao;

    private final ModelMapper modelMapper;

    @Override
    public String saveUser(UserDto userDto) {
        System.out.println("UserDto: " + userDto);
        Optional<User> userOptional = userDao.findByEmail(userDto.getEmail());
        Optional<Role> optionalRole = roleDao.getRoleById(userDto.getRole());
        if (userOptional.isPresent()) {
            throw new RuntimeException("Email already exist");
        }
        if (optionalRole.isPresent()) {
            User user = modelMapper.map(userDto, User.class);
            user.setRole(optionalRole.get());
            user.setIsDeleted(false);
            userDao.saveUser(user);
            return "User saved successfully";

        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public Integer loginUser(String email, String password) {
        Optional<User> optionalUser = userDao.findByEmail(email); // Assuming findByEmail exists in UserDao

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Check if the provided password matches the stored password
            if (password.equals(user.getPassword())) {
                return user.getId(); // Return user ID if authentication is successful
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void uploadDocument(Integer userId, String filePath, String description) {
        Optional<User> userOptional = userDao.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPicture(filePath);
            userDao.saveUser(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }


    public Optional<User> getUserDetails(Integer userId){
        return userDao.findById(userId);
    }

    public String editUser(Integer userId, UserDto userDto){

        Optional<User> userOptional = userDao.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            userDao.saveUser(user);
            return "User details updated successfully";
        }
        else{
            throw new RuntimeException("User not found");
        }
    }

}