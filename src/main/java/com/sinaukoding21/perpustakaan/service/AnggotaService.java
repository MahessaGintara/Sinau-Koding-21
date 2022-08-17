package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.enumeration.RoleUser;
import com.sinaukoding21.perpustakaan.model.Anggota;
import com.sinaukoding21.perpustakaan.model.User;
import com.sinaukoding21.perpustakaan.model.dto.AnggotaDto;
import com.sinaukoding21.perpustakaan.model.mapper.AnggotaMapper;
import com.sinaukoding21.perpustakaan.repository.AnggotaRepository;
import com.sinaukoding21.perpustakaan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnggotaService {

    @Autowired
    AnggotaRepository anggotaRepository;

    @Autowired
    UserRepository userRepository;

    public List<AnggotaDto> getAllAnggota() {

        return AnggotaMapper.INSTANCE.toListDto(anggotaRepository.findAll());
    }

    public AnggotaDto createAnggota(AnggotaDto anggota) {
        User userToUpdate = userRepository.findById(anggota.getUser().getId()).orElseThrow(null);

        if (userToUpdate != null) {
            userToUpdate.setRole(RoleUser.ANGGOTA);
            Anggota anggotaToCreate = AnggotaMapper.INSTANCE.toEntity(anggota);
            anggotaToCreate = anggotaRepository.save(anggotaToCreate);
            return AnggotaMapper.INSTANCE.toDto(anggotaToCreate);
        }else {
            return null;
        }
    }

    public boolean deleteAnggota(Integer id) {
        Anggota anggota = anggotaRepository.findById(id).orElseThrow(null);
        anggotaRepository.delete(anggota);

        try {
            anggotaRepository.delete(anggota);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Anggota updateAnggota(Integer id, Anggota anggota) {
        Anggota anggotaToUpdate = anggotaRepository.findById(id).orElseThrow(null);
        anggotaToUpdate.setNama(anggota.getNama() != null ? anggota.getNama() : anggotaToUpdate.getNama());
        anggotaToUpdate.setJenisKelamin(anggota.getJenisKelamin() != null ? anggota.getJenisKelamin() : anggotaToUpdate.getJenisKelamin());
        anggotaToUpdate.setAlamat(anggota.getAlamat() != null ? anggota.getAlamat() : anggotaToUpdate.getAlamat());
        anggotaToUpdate.setNoTelp(anggota.getNoTelp() != null ? anggota.getNoTelp() : anggotaToUpdate.getNoTelp());
        return anggotaRepository.save(anggotaToUpdate);
    }

    public Anggota getAnggotaById(Integer id) {
        return anggotaRepository.findById(id).orElseThrow(null);
    }
}
