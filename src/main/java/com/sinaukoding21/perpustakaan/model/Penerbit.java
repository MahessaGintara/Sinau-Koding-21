package com.sinaukoding21.perpustakaan.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "penerbit")
@Getter @Setter
public class Penerbit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column
    private String alamat;

    @Column(name = "telp")
    private String telp;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "penerbit",fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<Buku> bukus;
}
