package com.crack.vision.user.dao;

import org.springframework.stereotype.Repository;

import com.crack.vision.user.entity.User;
import com.crack.vision.user.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepo userRepo;

    @Override
    public User saveUser(User user) {

        try {
            return userRepo.save(user);
        } catch (Exception e) {
            throw e;
        }

    }

}
