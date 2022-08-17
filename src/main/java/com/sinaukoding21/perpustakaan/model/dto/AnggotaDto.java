package com.sinaukoding21.perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class AnggotaDto {
    private Integer id;
    private String nama;
    private String jenisKelamin;
    private String alamat;
    private String noTelp;
    private UserDto user;
}
