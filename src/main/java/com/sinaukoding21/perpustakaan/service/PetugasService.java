package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.enumeration.RoleUser;
import com.sinaukoding21.perpustakaan.model.Petugas;
import com.sinaukoding21.perpustakaan.model.User;
import com.sinaukoding21.perpustakaan.model.dto.PetugasDto;
import com.sinaukoding21.perpustakaan.model.mapper.PetugasMapper;
import com.sinaukoding21.perpustakaan.repository.PetugasRepository;
import com.sinaukoding21.perpustakaan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasService {
    @Autowired
    PetugasRepository petugasRepository;

    @Autowired
    UserRepository userRepository;

    public List<PetugasDto> getAllPetugas() {
        return PetugasMapper.INSTANCE.toListDto(petugasRepository.findAll());
    }

    public PetugasDto createPetugas(PetugasDto petugas) {
        User userToUpdate = userRepository.findById(petugas.getUser().getId()).orElseThrow(null);
        if (userToUpdate != null){
            userToUpdate.setRole(RoleUser.PETUGAS);
            Petugas petugas1 = PetugasMapper.INSTANCE.toEntity(petugas);
            petugas1 = petugasRepository.save(petugas1);
            return PetugasMapper.INSTANCE.toDto(petugas1);
        }else {
            return null;
        }

    }

    public boolean deletePetugas(Integer id) {
        Petugas petugas = petugasRepository.findById(id).orElseThrow(null);
        petugasRepository.delete(petugas);

        try {
            petugasRepository.delete(petugas);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Petugas updatePetugas(Integer id, Petugas petugas) {
        Petugas petugasToUpdate = petugasRepository.findById(id).orElseThrow(null);
        petugasToUpdate.setNama(petugas.getNama() != null ? petugas.getNama() : petugasToUpdate.getNama());
        petugasToUpdate.setTelp(petugas.getTelp() != null ? petugas.getTelp() : petugasToUpdate.getTelp());
        petugasToUpdate.setAlamat(petugas.getAlamat() != null ? petugas.getAlamat() : petugasToUpdate.getAlamat());
        return petugasRepository.save(petugasToUpdate);
    }

    public Petugas getPetugasById(Integer id) {
        return petugasRepository.findById(id).orElseThrow(null);
    }
}
