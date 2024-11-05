package com.crack.vision.user.entity;

import com.crack.vision.common.entity.SuperEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends SuperEntity {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "picture")
    private String picture;

    @Column(name = "country_code")
    private String countryCode;

}
