package com.crack.vision.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserDto {

    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String phone;
    @NotNull
    private Integer role;
    @NotNull
    @NotBlank
    private String picture;
    @NotNull
    @NotBlank
    private String countryCode;

}
