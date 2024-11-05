package com.crack.vision.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crack.vision.user.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
