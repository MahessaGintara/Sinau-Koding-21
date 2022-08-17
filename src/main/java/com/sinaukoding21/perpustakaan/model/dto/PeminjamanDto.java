package com.sinaukoding21.perpustakaan.model.dto;

import com.sinaukoding21.perpustakaan.model.Buku;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class PeminjamanDto {
    private Integer id;
    private Date tglPinjam;
    private Date tglKembali;
    private AnggotaDto anggota;
    private PetugasDto petugas;
    private List<Buku> buku;
}
