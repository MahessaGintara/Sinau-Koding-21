package com.sinaukoding21.perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "anggota")
@Getter @Setter
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "jenis_kelamin", nullable = false)
    private String jenisKelamin;

    @Column(name = "alamat", nullable = false)
    private String alamat;


    @Column(name = "no_telp", nullable = false, length = 20)
    private String noTelp;

    @Getter(AccessLevel.NONE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @JsonBackReference
    private User user;
}
