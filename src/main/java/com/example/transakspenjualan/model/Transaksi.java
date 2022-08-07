package com.example.transakspenjualan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Column
    private Date tglTransaksi;

    @Column
    private String keterangan;

    @Transient
    @OneToOne(mappedBy = "transaksi", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Pembayaran pembayaran;
}
