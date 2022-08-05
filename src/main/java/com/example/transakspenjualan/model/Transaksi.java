package com.example.transakspenjualan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Column
    private Date tglTransaksi;

    @Column
    private String keterangan;

    @OneToOne(mappedBy = "transaksi")
    private Pembayaran pembayaran;
}
