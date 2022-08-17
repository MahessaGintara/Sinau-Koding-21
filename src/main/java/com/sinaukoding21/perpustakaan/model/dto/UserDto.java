package com.sinaukoding21.perpustakaan.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sinaukoding21.perpustakaan.enumeration.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private RoleUser role;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
    private AnggotaDto anggota;
    private PetugasDto petugas;
}
