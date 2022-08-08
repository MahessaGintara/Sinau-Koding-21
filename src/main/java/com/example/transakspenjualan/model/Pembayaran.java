package com.example.transakspenjualan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pembayaran")

public class Pembayaran {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column
    private Date tglBayar;

    @Getter
    @Setter
    @Column
    private Double total;

    @Setter
    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_transaksi")
    private Transaksi transaksi;
}
