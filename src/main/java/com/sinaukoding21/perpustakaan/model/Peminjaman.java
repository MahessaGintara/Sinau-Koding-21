package com.sinaukoding21.perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "peminjaman")
@Getter @Setter
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date tglPinjam;

    @Column
    private Date tglKembali;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "anggota_id")
    private Anggota anggota;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "petugas_id")
    private Petugas petugas;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "peminjaman_detail",
            joinColumns = @JoinColumn(name = "peminjaman_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "buku_id", referencedColumnName = "id")
    )
    private List<Buku> buku;
}
