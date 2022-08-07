package com.example.transakspenjualan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pembayaran")
@Getter
@Setter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date tglBayar;

    @Column
    private Double total;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_transaksi")
    private Transaksi transaksi;
}
