package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.model.Buku;
import com.sinaukoding21.perpustakaan.model.dto.BukuDto;
import com.sinaukoding21.perpustakaan.model.mapper.BukuMapper;
import com.sinaukoding21.perpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BukuService {

    @Autowired
    BukuRepository bukuRepository;

    public List<BukuDto> getAllBuku() {
        return BukuMapper.INSTANCE.toListDto(bukuRepository.findAll());
    }

    public BukuDto createBuku(BukuDto buku) {
        Buku buku1 = BukuMapper.INSTANCE.toEntity(buku);
        buku1 = bukuRepository.save(buku1);
        return BukuMapper.INSTANCE.toDto(buku1);
    }

    public boolean deleteBuku(Integer id) {
        Buku buku = bukuRepository.findById(id).orElseThrow(null);
        bukuRepository.delete(buku);

        try {
            bukuRepository.delete(buku);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Buku updateBuku(Integer id, Buku buku) {
        Buku bukuToUpdate = bukuRepository.findById(id).orElseThrow(null);
        bukuToUpdate.setJudul(buku.getJudul() != null ? buku.getJudul() : bukuToUpdate.getJudul());
        bukuToUpdate.setTahunTerbit(buku.getTahunTerbit() != null ? buku.getTahunTerbit() : bukuToUpdate.getTahunTerbit());
        bukuToUpdate.setJumlah(buku.getJumlah() != null ? buku.getJumlah() : bukuToUpdate.getJumlah());
        bukuToUpdate.setIsbn(buku.getIsbn() != null ? buku.getIsbn() : bukuToUpdate.getIsbn());
        return bukuRepository.save(bukuToUpdate);
    }

    public Buku getBukuById(Integer id) {
        return bukuRepository.findById(id).orElseThrow(null);
    }

    public List<Buku> findByJudul(String name){
        return bukuRepository.findByJudul(name);
    }

}
