package com.example.transakspenjualan.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class SupplierDTO {
    private Integer id;

    private String namaSupplier;

    private String noTelp;

    private String alamat;

}
