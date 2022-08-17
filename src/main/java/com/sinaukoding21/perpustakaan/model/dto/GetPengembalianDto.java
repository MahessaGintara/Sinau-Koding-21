package com.sinaukoding21.perpustakaan.model.dto;

import com.sinaukoding21.perpustakaan.model.Peminjaman;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GetPengembalianDto {
    private Integer id;
    private String tglPengembalian;
    private Double denda;
    private Integer peminjaman;
    private String anggota;
    private String petugas;
    private List<GetBukuDto> buku;
}
