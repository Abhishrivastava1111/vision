package com.crack.vision.user.entity;

import com.crack.vision.common.entity.SuperEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = false)

public class Role extends SuperEntity{

    @Column(name = "name")
    private String name;
}
