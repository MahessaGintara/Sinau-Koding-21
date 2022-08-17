package com.sinaukoding21.perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetugasDto {
    private Integer id;
    private String nama;
    private String telp;
    private String alamat;
    private UserDto user;
}
