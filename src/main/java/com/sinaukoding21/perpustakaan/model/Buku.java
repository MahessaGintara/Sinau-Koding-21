package com.sinaukoding21.perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buku")
@Getter @Setter
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "judul", nullable = false)
    private String judul;

    @Column
    private String tahunTerbit;

    @Column
    private Integer jumlah;

    @Column
    private String isbn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pengarang_id")
    private Pengarang pengarang;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "penerbit_id")
    private Penerbit penerbit;

    @Getter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "buku", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Peminjaman> peminjaman;

    @Getter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "buku", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Pengembalian> pengembalians;
}
