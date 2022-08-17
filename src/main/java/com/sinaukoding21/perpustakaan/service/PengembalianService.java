package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.model.Pengembalian;
import com.sinaukoding21.perpustakaan.model.dto.GetPengembalianDto;
import com.sinaukoding21.perpustakaan.model.dto.PengembalianDto;
import com.sinaukoding21.perpustakaan.model.mapper.PengembalianMapper;
import com.sinaukoding21.perpustakaan.repository.PengembalianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PengembalianService {
    @Autowired
    PengembalianRepository pengembalianRepository;

    public List<GetPengembalianDto> getAllPengembalian() {
        List<Pengembalian> pengembalianList = pengembalianRepository.findAll();
        if (pengembalianList.size() > 0 ) {
            List<GetPengembalianDto> getPengembalianDtos = new ArrayList<>();
            for (Pengembalian pengembalian : pengembalianList){
                GetPengembalianDto pengembalianDto = new GetPengembalianDto();
                pengembalianDto.setId(pengembalian.getId());
                pengembalianDto.setTglPengembalian(pengembalian.getTglPengembalian());
                pengembalianDto.setDenda(pengembalian.getDenda());
                pengembalianDto.setPeminjaman(pengembalian.getPeminjaman().getId());
                pengembalianDto.setAnggota(pengembalian.getAnggota().getNama());
                pengembalianDto.setPetugas(pengembalian.getPetugas().getNama());
                pengembalianDto.setBuku(GetterService.getBuku(pengembalian.getBuku()));
                getPengembalianDtos.add(pengembalianDto);
            }
            return getPengembalianDtos;
        } else {
          return new ArrayList<>();
        }
    }

    public PengembalianDto createPengembalian(PengembalianDto pengembalian) {
        Pengembalian pengembalianToCreate = PengembalianMapper.INSTANCE.toEntity(pengembalian);
        pengembalianToCreate = pengembalianRepository.save(pengembalianToCreate);
        return PengembalianMapper.INSTANCE.toDto(pengembalianToCreate);
    }

    public boolean deletePengembalian(Integer id) {
        Pengembalian pengembalian = pengembalianRepository.findById(id).orElseThrow(null);
        pengembalianRepository.delete(pengembalian);

        try {
            pengembalianRepository.delete(pengembalian);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Pengembalian updatePengembalian(Integer id, Pengembalian pengembalian) {
        Pengembalian pengembalianToUpdate = pengembalianRepository.findById(id).orElseThrow(null);
        pengembalianToUpdate.setTglPengembalian(pengembalian.getTglPengembalian() != null ? pengembalian.getTglPengembalian() : pengembalianToUpdate.getTglPengembalian());
        pengembalianToUpdate.setDenda(pengembalian.getDenda() != null ? pengembalian.getDenda() : pengembalianToUpdate.getDenda());
        pengembalianToUpdate.setPeminjaman(pengembalian.getPeminjaman() != null ? pengembalian.getPeminjaman() : pengembalianToUpdate.getPeminjaman());
        pengembalianToUpdate.setAnggota(pengembalian.getAnggota() != null ? pengembalian.getAnggota() : pengembalianToUpdate.getAnggota());
        pengembalianToUpdate.setPetugas(pengembalian.getPetugas() != null ? pengembalian.getPetugas() : pengembalianToUpdate.getPetugas());
        return pengembalianRepository.save(pengembalianToUpdate);
    }

    public Pengembalian getPengembalianById(Integer id) {
        return pengembalianRepository.findById(id).orElseThrow(null);
    }
}
