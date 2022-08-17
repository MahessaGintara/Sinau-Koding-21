package com.sinaukoding21.perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistrationDto {
    private String username;
    private String password;
    private String email;
    private String role;
}
