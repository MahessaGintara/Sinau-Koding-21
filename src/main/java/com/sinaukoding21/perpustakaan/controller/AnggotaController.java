package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Anggota;
import com.sinaukoding21.perpustakaan.model.dto.AnggotaDto;
import com.sinaukoding21.perpustakaan.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {
    @Autowired
    AnggotaService anggotaService;

    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    @GetMapping
    public Response getAllAnggota() {
        return new Response(
                anggotaService.getAllAnggota(),
                anggotaService.getAllAnggota().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response createAnggota(@RequestBody AnggotaDto anggota) {
        return new Response (
                anggotaService.createAnggota(anggota),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response deleteAnggota(@PathVariable Integer id) {
        if (anggotaService.deleteAnggota(id)){
            return new Response (
                    "Anggota Berhasil Dihapus",
                    HttpStatus.OK
            );
        } else {
            return new Response (
                    "Anggota Gagal Dihapus",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response updateAnggota(@PathVariable Integer id, @RequestBody Anggota anggota) {
        return new Response(
                anggotaService.updateAnggota(id, anggota),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response getAnggotaById(@PathVariable Integer id) {
        Anggota anggota = anggotaService.getAnggotaById(id);
        return new Response(
                anggota,
                anggota != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }
}
