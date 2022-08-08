package com.example.transakspenjualan.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDTO {
    private Integer id;
    private String namaBarang;
    private Double harga;
    private Integer stok;
    private SupplierDTO supplier;
}
