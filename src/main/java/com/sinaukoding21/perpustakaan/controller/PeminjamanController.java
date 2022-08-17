package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Peminjaman;
import com.sinaukoding21.perpustakaan.model.dto.PeminjamanDto;
import com.sinaukoding21.perpustakaan.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {

    @Autowired
    PeminjamanService peminjamanService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ANGGOTA', 'PETUGAS', 'ADMIN')")
    public Response getAllPeminjaman() {
        return new Response(
                peminjamanService.getAllPeminjaman(),
                peminjamanService.getAllPeminjaman().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ANGGOTA', 'PETUGAS', 'ADMIN')")
    public Response createPeminjaman(@RequestBody PeminjamanDto peminjaman) {
        PeminjamanDto peminjamanDto = peminjaman;
        return new Response(
                peminjamanService.createPeminjaman(peminjaman),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response deletePeminjaman(@PathVariable Integer id) {
        if (peminjamanService.deletePeminjaman(id)) {
            return new Response("Peminjaman Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Peminjaman Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response updatePeminjaman(@PathVariable Integer id, @RequestBody Peminjaman peminjaman) {
        return new Response(
                peminjamanService.updatePeminjaman(id, peminjaman),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ANGGOTA', 'PETUGAS', 'ADMIN')")
    public Response getPeminjamanById(@PathVariable Integer id) {
        Peminjaman peminjaman = peminjamanService.getPeminjamanById(id);
        return new Response(
                peminjaman,
                peminjaman != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }
}
