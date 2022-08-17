package com.sinaukoding21.perpustakaan.service;
import com.sinaukoding21.perpustakaan.model.Peminjaman;
import com.sinaukoding21.perpustakaan.model.dto.GetPeminjamanDto;
import com.sinaukoding21.perpustakaan.model.dto.PeminjamanDto;
import com.sinaukoding21.perpustakaan.model.mapper.PeminjamanMapper;
import com.sinaukoding21.perpustakaan.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeminjamanService {

    @Autowired
    PeminjamanRepository peminjamanRepository;

    public List<GetPeminjamanDto> getAllPeminjaman() {
        List<Peminjaman> peminjamanList = peminjamanRepository.findAll();
        if (peminjamanList.size() > 0) {
            List<GetPeminjamanDto> peminjamanModelList = new ArrayList<>();
            for (Peminjaman peminjaman : peminjamanList) {
                GetPeminjamanDto peminjamanModel = new GetPeminjamanDto();
                peminjamanModel.setId(peminjaman.getId());
                peminjamanModel.setTglPinjam(peminjaman.getTglPinjam());
                peminjamanModel.setTglKembali(peminjaman.getTglKembali());
                peminjamanModel.setAnggota(peminjaman.getAnggota().getNama());
                peminjamanModel.setPetugas(peminjaman.getPetugas().getNama());
                peminjamanModel.setBuku(GetterService.getBuku(peminjaman.getBuku()));
                peminjamanModelList.add(peminjamanModel);
            }
            return peminjamanModelList;
        } else {
            return new ArrayList<>();
        }
    }


    public PeminjamanDto createPeminjaman(PeminjamanDto peminjaman) {
        Peminjaman peminjaman1 = PeminjamanMapper.INSTANCE.toEntity(peminjaman);
        peminjaman1 = peminjamanRepository.save(peminjaman1);
        return PeminjamanMapper.INSTANCE.toDto(peminjaman1);
    }

    public boolean deletePeminjaman(Integer id) {
        Peminjaman peminjaman = peminjamanRepository.findById(id).orElseThrow(null);
        peminjamanRepository.delete(peminjaman);

        try {
            peminjamanRepository.delete(peminjaman);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Peminjaman updatePeminjaman(Integer id, Peminjaman peminjaman) {
        Peminjaman peminjamanToUpdate = peminjamanRepository.findById(id).orElseThrow(null);
        peminjamanToUpdate.setTglPinjam(peminjaman.getTglPinjam() != null ? peminjaman.getTglPinjam() : peminjamanToUpdate.getTglPinjam());
        peminjamanToUpdate.setTglKembali(peminjaman.getTglKembali() != null ? peminjaman.getTglKembali() : peminjamanToUpdate.getTglKembali());
        peminjamanToUpdate.setAnggota(peminjaman.getAnggota() != null ? peminjaman.getAnggota() : peminjamanToUpdate.getAnggota());
        peminjamanToUpdate.setPetugas(peminjaman.getPetugas() != null ? peminjaman.getPetugas() : peminjamanToUpdate.getPetugas());
        return peminjamanRepository.save(peminjamanToUpdate);
    }

    public Peminjaman getPeminjamanById(Integer id) {
        return peminjamanRepository.findById(id).orElseThrow(null);
    }
}
