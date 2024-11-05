package com.crack.vision.user.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crack.vision.user.entity.Role;
import com.crack.vision.user.repo.RoleRepo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private final RoleRepo roleRepo;

    @Override
    public Optional<Role> getRoleById(Integer id) {
        try {
            return roleRepo.findByIdAndIsDeletedFalse(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
