package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Pengarang;
import com.sinaukoding21.perpustakaan.model.dto.PengarangDto;
import com.sinaukoding21.perpustakaan.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pengarang")
public class PengarangController {

    @Autowired
    PengarangService pengarangService;

    @GetMapping
    public Response getAllPengarang() {
        return new Response(
                pengarangService.getAllPengarang(),
                pengarangService.getAllPengarang().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public Response createPengarang(@RequestBody PengarangDto nama) {
        return new Response(
                pengarangService.createPengarang(nama),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public Response deletePengarang(@PathVariable Integer id) {
        if (pengarangService.deletePengarang(id)) {
            return new Response("Pengarang Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Pengarang Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Response updatePengarang(@PathVariable Integer id, @RequestBody Pengarang nama) {
        return new Response(
                pengarangService.updatePengarang(id, nama),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Response getPengarangById(@PathVariable Integer id) {
        Pengarang pengarang = pengarangService.getPengarangById(id);
        return new Response(
                pengarang,
                pengarang != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }
}
