package com.example.transakspenjualan.service;

import com.example.transakspenjualan.dto.PembayaranDTO;
import com.example.transakspenjualan.mapper.PembayaranMapper;
import com.example.transakspenjualan.model.Pembayaran;
import com.example.transakspenjualan.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;

    public List<PembayaranDTO> getAllPembayaran() {
        return PembayaranMapper.INSTANCE.toListDto(pembayaranRepository.findAll());
    }

    public PembayaranDTO createPembayaran(PembayaranDTO pembayaran) {
        Pembayaran pembayaran1 = PembayaranMapper.INSTANCE.toEntity(pembayaran);
        pembayaran1 = pembayaranRepository.save(pembayaran1);
        return PembayaranMapper.INSTANCE.toDto(pembayaran1);
    }

    public void deletePembayaran(Integer id) {
        pembayaranRepository.deleteById(id);
    }

    public Pembayaran updatePembayaran(Integer id, Pembayaran pembayaran) {
        Pembayaran pembayaranToUpdate = pembayaranRepository.findById(id).get();
        pembayaranToUpdate.setTglBayar(pembayaran.getTglBayar() != null ? pembayaran.getTglBayar() : pembayaranToUpdate.getTglBayar());
        pembayaranToUpdate.setTotal(pembayaran.getTotal() != null ? pembayaran.getTotal() : pembayaranToUpdate.getTotal());
        return pembayaranRepository.save(pembayaranToUpdate);
    }
}
