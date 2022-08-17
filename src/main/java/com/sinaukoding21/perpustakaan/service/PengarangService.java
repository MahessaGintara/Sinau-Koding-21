package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.model.Pengarang;
import com.sinaukoding21.perpustakaan.model.dto.PengarangDto;
import com.sinaukoding21.perpustakaan.model.mapper.PengarangMapper;
import com.sinaukoding21.perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengarangService {
    @Autowired
    PengarangRepository pengarangRepository;

    public List<PengarangDto> getAllPengarang() {
        return PengarangMapper.INSTANCE.toListDto(pengarangRepository.findAll());
    }

    public PengarangDto createPengarang(PengarangDto pengarang) {
        Pengarang pengarangToCreate = PengarangMapper.INSTANCE.toEntity(pengarang);
        pengarangToCreate = pengarangRepository.save(pengarangToCreate);
        return PengarangMapper.INSTANCE.toDto(pengarangToCreate);
    }

    public boolean deletePengarang(Integer id) {
        Pengarang pengarang = pengarangRepository.findById(id).orElseThrow(null);
        pengarangRepository.delete(pengarang);

        try {
            pengarangRepository.delete(pengarang);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Pengarang updatePengarang(Integer id, Pengarang pengarang) {
        Pengarang pengarangToUpdate = pengarangRepository.findById(id).orElseThrow(null);
        pengarangToUpdate.setNama(pengarang.getNama() != null ? pengarang.getNama() : pengarangToUpdate.getNama());
        pengarangToUpdate.setAlamat(pengarang.getAlamat() != null ? pengarang.getAlamat() : pengarangToUpdate.getAlamat());
        pengarangToUpdate.setTelp(pengarang.getTelp() != null ? pengarang.getTelp() : pengarangToUpdate.getTelp());
        return pengarangRepository.save(pengarangToUpdate);
    }

    public Pengarang getPengarangById(Integer id) {
        return pengarangRepository.findById(id).orElseThrow(null);
    }
}
