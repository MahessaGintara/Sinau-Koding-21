package com.sinaukoding21.perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateBukuDto {
    private Integer id;
    private String judul;
    private String tahunTerbit;
    private Integer jumlah;
    private String isbn;
}
