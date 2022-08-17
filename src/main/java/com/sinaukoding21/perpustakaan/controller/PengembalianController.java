package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Pengembalian;
import com.sinaukoding21.perpustakaan.model.dto.PengembalianDto;
import com.sinaukoding21.perpustakaan.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pengembalian")
public class PengembalianController {
    @Autowired
    PengembalianService pengembalianService;

    @GetMapping
    public Response getAllPengembalian() {
        return new Response(
                pengembalianService.getAllPengembalian(),
                pengembalianService.getAllPengembalian().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public Response createPengembalian(@RequestBody PengembalianDto pengembalian) {
        return new Response(
                pengembalianService.createPengembalian(pengembalian),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public Response deletePengembalian(@PathVariable Integer id) {
            if (pengembalianService.deletePengembalian(id)) {
                return new Response("Pengembalian Berhasil Dihapus", HttpStatus.OK);
            } else {
                return new Response("Pengembalian Gagal Dihapus", HttpStatus.BAD_REQUEST);
            }
        }

    @PutMapping("/{id}")
    public Response updatePengembalian(@PathVariable Integer id ,@RequestBody Pengembalian pengembalian) {
        return new Response(
                pengembalianService.updatePengembalian(id, pengembalian),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Response getPengembalianById(@PathVariable Integer id) {
        Pengembalian pengembalian = pengembalianService.getPengembalianById(id);
        return new Response(
                pengembalian,
                pengembalian != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }

}
