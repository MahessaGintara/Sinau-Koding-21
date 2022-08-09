package com.example.transakspenjualan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PembayaranDTO {
    private Integer id;

    // private TransaksiDTO transaksi;

    private Double total;

    private Date tglBayar;
}
