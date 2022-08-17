package com.sinaukoding21.perpustakaan.model.dto;

import com.sinaukoding21.perpustakaan.model.Peminjaman;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter @Setter
public class PengembalianDto {
    private Integer id;
    private String tglPengembalian;
    private Double denda;
    private Peminjaman peminjaman;
    private AnggotaDto anggota;
    private PetugasDto petugas;
    private List<BukuDto> buku;
}
