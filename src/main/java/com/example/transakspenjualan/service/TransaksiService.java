package com.example.transakspenjualan.service;

import com.example.transakspenjualan.dto.TransaksiDTO;
import com.example.transakspenjualan.mapper.TransaksiMapper;
import com.example.transakspenjualan.model.Transaksi;
import com.example.transakspenjualan.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public List<TransaksiDTO> getAllTransaksi() {
        return TransaksiMapper.INSTANCE.toListDto(transaksiRepository.findAll());
    }

    public TransaksiDTO createTransaksi(TransaksiDTO transaksi){
        Transaksi transaksi1 = TransaksiMapper.INSTANCE.toEntity(transaksi);
        transaksi1 = transaksiRepository.save(transaksi1);
        return TransaksiMapper.INSTANCE.toDto(transaksi1);
    }

    public void deleteTransaksi(Integer id){
        transaksiRepository.deleteById(id);
    }

    public Transaksi updateTransaksi(Integer id, Transaksi transaksi) {
        Transaksi transaksiToUpdate = transaksiRepository.findById(id).get();
        transaksiToUpdate.setTglTransaksi(transaksi.getTglTransaksi() != null ? transaksi.getTglTransaksi() : transaksiToUpdate.getTglTransaksi());
        transaksiToUpdate.setKeterangan(transaksi.getKeterangan() != null ? transaksi.getKeterangan() : transaksiToUpdate.getKeterangan());
        return transaksiRepository.save(transaksiToUpdate);
    }
}
