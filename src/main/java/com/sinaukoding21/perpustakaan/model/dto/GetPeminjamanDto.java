package com.sinaukoding21.perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class GetPeminjamanDto {
    private Integer id;
    private Date tglPinjam;
    private Date tglKembali;
    private String anggota;
    private String petugas;
    private List<GetBukuDto> buku;
}
