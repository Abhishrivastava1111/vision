package com.crack.vision.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginDto {

    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
}
