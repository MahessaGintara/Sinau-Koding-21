package com.example.transakspenjualan.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaksiDTO {
    private Integer id;
    private PembeliDTO pembeli;
    private BarangDTO barang;
    private Date tglTransaksi;
    private String keterangan;
    private PembayaranDTO pembayaran;
}
