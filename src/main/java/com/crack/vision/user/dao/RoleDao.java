package com.crack.vision.user.dao;

import java.util.Optional;

import com.crack.vision.user.entity.Role;

public interface RoleDao {

    Optional<Role> getRoleById(Integer id);

}
