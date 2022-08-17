package com.sinaukoding21.perpustakaan.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "petugas")
@Getter
@Setter
public class Petugas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "telp", length = 20)
    private String telp;

    @Column(name = "alamat")
    private String alamat;

    @Getter(AccessLevel.NONE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
}
