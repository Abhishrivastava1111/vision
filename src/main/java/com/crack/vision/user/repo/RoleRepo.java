package com.crack.vision.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crack.vision.user.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Optional<Role> findByIdAndIsDeletedFalse(Integer id);

}
