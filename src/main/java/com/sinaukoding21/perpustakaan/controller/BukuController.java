package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Buku;
import com.sinaukoding21.perpustakaan.model.dto.BukuDto;
import com.sinaukoding21.perpustakaan.model.dto.UpdateBukuDto;
import com.sinaukoding21.perpustakaan.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    BukuService bukuService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ANGGOTA', 'PETUGAS', 'ADMIN')")
    public Response getAllBuku() {
       return new Response(
               bukuService.getAllBuku(),
               bukuService.getAllBuku().size(),
               HttpStatus.OK
       );
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response createBuku(@RequestBody BukuDto buku) {
        return new Response (
                bukuService.createBuku(buku),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response deleteBuku(@PathVariable Integer id) {
        if (bukuService.deleteBuku(id)){
            return new Response (
                    "Buku Berhasil Dihapus",
                    HttpStatus.OK
            );
        } else {
            return new Response (
                    "Buku Gagal Dihapus",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response updateBuku(@PathVariable Integer id, @RequestBody Buku buku) {
        return new Response(
                bukuService.updateBuku(id, buku),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ANGGOTA', 'PETUGAS', 'ADMIN')")
    public Response getBukuById(@PathVariable Integer id) {
        Buku buku = bukuService.getBukuById(id);
        return new Response(
                buku,
                buku != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }

    @GetMapping("/{judul}")
    @PreAuthorize("hasAnyAuthority('ANGGOTA', 'PETUGAS', 'ADMIN')")
    public Response findByJudul(@PathVariable String judul) {
        return new Response(
                bukuService.findByJudul(judul),
                bukuService.findByJudul(judul).size(),
                HttpStatus.OK
        );
    }
}
