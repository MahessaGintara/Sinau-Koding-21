package com.example.transakspenjualan.repository;

import com.example.transakspenjualan.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {


}
