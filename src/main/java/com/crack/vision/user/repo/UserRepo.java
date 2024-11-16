package com.crack.vision.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crack.vision.user.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndIsDeletedFalse(String email);

}
