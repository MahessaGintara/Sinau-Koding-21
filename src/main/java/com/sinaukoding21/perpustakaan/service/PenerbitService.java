package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.model.Penerbit;
import com.sinaukoding21.perpustakaan.model.dto.PenerbitDto;
import com.sinaukoding21.perpustakaan.model.mapper.PenerbitMapper;
import com.sinaukoding21.perpustakaan.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenerbitService {
    @Autowired
    PenerbitRepository penerbitRepository;

    public List<PenerbitDto> getAllPenerbit() {
        return PenerbitMapper.INSTANCE.toListDto(penerbitRepository.findAll());
    }

    public PenerbitDto createPenerbit(PenerbitDto penerbit) {
        Penerbit penerbit1 = PenerbitMapper.INSTANCE.toEntity(penerbit);
        penerbit1 = penerbitRepository.save(penerbit1);
        return PenerbitMapper.INSTANCE.toDto(penerbit1);
    }

    public boolean deletePenerbit(Integer id) {
        Penerbit penerbit = penerbitRepository.findById(id).orElseThrow(null);
        penerbitRepository.delete(penerbit);

        try {
            penerbitRepository.delete(penerbit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Penerbit updatePenerbit(Integer id, Penerbit penerbit) {
        Penerbit penerbitToUpdate = penerbitRepository.findById(id).orElseThrow(null);
        penerbitToUpdate.setNama(penerbit.getNama() != null ? penerbit.getNama() : penerbitToUpdate.getNama());
        penerbitToUpdate.setAlamat(penerbit.getAlamat() != null ? penerbit.getAlamat() : penerbitToUpdate.getAlamat());
        penerbitToUpdate.setTelp(penerbit.getTelp() != null ? penerbit.getTelp() : penerbitToUpdate.getTelp());
        return penerbitRepository.save(penerbitToUpdate);
    }

    public Penerbit getPenerbitById(Integer id) {
        return penerbitRepository.findById(id).orElseThrow(null);
    }
}
