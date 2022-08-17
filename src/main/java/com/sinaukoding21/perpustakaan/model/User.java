package com.sinaukoding21.perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sinaukoding21.perpustakaan.enumeration.RoleUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleUser role = RoleUser.NONE;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Anggota anggota;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Petugas petugas;
}
