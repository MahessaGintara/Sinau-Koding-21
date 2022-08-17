package com.sinaukoding21.perpustakaan.model.dto;

import com.sinaukoding21.perpustakaan.model.Peminjaman;
import com.sinaukoding21.perpustakaan.model.Pengembalian;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BukuDto {
    private Integer id;
    private String judul;
    private String tahunTerbit;
    private Integer jumlah;
    private String isbn;
    private PengarangDto pengarang;
    private PenerbitDto penerbit;
    private List<Peminjaman> peminjaman;
    private List<Pengembalian> pengembalians;
}
