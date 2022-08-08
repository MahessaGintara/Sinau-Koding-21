package com.example.transakspenjualan.service;

import com.example.transakspenjualan.dto.PembeliDTO;
import com.example.transakspenjualan.mapper.PembeliMapper;
import com.example.transakspenjualan.model.Pembeli;
import com.example.transakspenjualan.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository pembeliRepository;

    public List<Pembeli> getAllPembeli() {
        return PembeliMapper.INSTANCE.toListEntity(pembeliRepository.findAll());
    }

    public PembeliDTO createPembeli(PembeliDTO pembeli) {
        Pembeli pembeli1 = PembeliMapper.INSTANCE.toEntity(pembeli);
        pembeli1 = pembeliRepository.save(pembeli1);
        return PembeliMapper.INSTANCE.toDto(pembeli1);
    }

    public void deletePembeli(Integer id) {
        pembeliRepository.deleteById(id);
    }

    public Pembeli updatePembeli(Integer id, Pembeli pembeli) {
        Pembeli pembeliToUpdate = pembeliRepository.findById(id).get();
        pembeliToUpdate.setNamaPembeli(pembeli.getNamaPembeli() != null ? pembeli.getNamaPembeli() : pembeliToUpdate.getNamaPembeli());
        pembeliToUpdate.setNoTelp(pembeli.getNoTelp() != null ? pembeli.getNoTelp() : pembeliToUpdate.getNoTelp());
        pembeliToUpdate.setAlamat(pembeli.getAlamat() != null ? pembeli.getAlamat() : pembeliToUpdate.getAlamat());
        return pembeliRepository.save(pembeliToUpdate);
    }
}
