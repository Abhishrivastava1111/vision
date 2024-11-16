package com.crack.vision.user.dao;

import java.util.Optional;

import com.crack.vision.user.entity.User;

public interface UserDao {

    User saveUser(User user);

    Optional<User> findByEmail(String email);
}
