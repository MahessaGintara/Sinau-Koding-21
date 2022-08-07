package com.example.transakspenjualan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "barang")
@Getter
@Setter
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga" , length = 30)
    private Double harga;

    @Column(name = "stok")
    private Integer stok;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

}
