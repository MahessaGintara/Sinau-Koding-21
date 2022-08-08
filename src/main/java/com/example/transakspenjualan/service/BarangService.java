package com.example.transakspenjualan.service;

import com.example.transakspenjualan.dto.BarangDTO;
import com.example.transakspenjualan.mapper.BarangMapper;
import com.example.transakspenjualan.model.Barang;
import com.example.transakspenjualan.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {

    @Autowired
    BarangRepository barangRepository;

    public List<BarangDTO> getAllBarang() {
        return BarangMapper.INSTANCE.toListDto(barangRepository.findAll());
    }

    public BarangDTO createBarang(BarangDTO barang) {
        Barang barang1 = BarangMapper.INSTANCE.toEntity(barang);
        barang1 = barangRepository.save(barang1);
        return BarangMapper.INSTANCE.toDto(barang1);
    }

    public void deleteBarang(Integer id) {
        barangRepository.deleteById(id);
    }

    public Barang updateBarang(Integer id, Barang barang) {
        Barang barangToUpdate = barangRepository.findById(id).orElseThrow(null);
        barangToUpdate.setNamaBarang(barang.getNamaBarang() != null ? barang.getNamaBarang() : barangToUpdate.getNamaBarang());
        barangToUpdate.setHarga(barang.getHarga() != null ? barang.getHarga() : barangToUpdate.getHarga());
        barangToUpdate.setStok(barang.getStok() != null ? barang.getStok() : barangToUpdate.getStok());
        barangToUpdate.setSupplier(barang.getSupplier() != null ? barang.getSupplier() : barangToUpdate.getSupplier());
        return barangRepository.save(barangToUpdate);
    }
}
