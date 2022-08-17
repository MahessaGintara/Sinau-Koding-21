package com.sinaukoding21.perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "pengarang")
@Getter @Setter
public class Pengarang {
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
    @OneToMany(mappedBy = "pengarang",fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<Buku> bukus;
}
