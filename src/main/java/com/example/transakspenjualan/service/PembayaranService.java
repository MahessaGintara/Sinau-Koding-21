package com.example.transakspenjualan.service;

import com.example.transakspenjualan.model.Pembayaran;
import com.example.transakspenjualan.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;

    public List<Pembayaran> getAllPembayaran() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran createPembayaran(Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
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
