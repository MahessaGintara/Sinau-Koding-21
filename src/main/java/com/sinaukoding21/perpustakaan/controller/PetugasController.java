package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Petugas;
import com.sinaukoding21.perpustakaan.model.dto.PetugasDto;
import com.sinaukoding21.perpustakaan.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petugas")
public class PetugasController {
    @Autowired
    PetugasService petugasService;

    @GetMapping
    public Response getAllPetugas() {
        return new Response(
                petugasService.getAllPetugas(),
                petugasService.getAllPetugas().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public Response createPetugas(@RequestBody PetugasDto petugas) {
        return new Response(
                petugasService.createPetugas(petugas),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public Response deletePetugas(@PathVariable Integer id) {
        if (petugasService.deletePetugas(id)) {
            return new Response("Petugas Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Petugas Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Response updatePetugas(@PathVariable Integer id, @RequestBody Petugas petugas) {
        return new Response(
                petugasService.updatePetugas(id, petugas),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Response getPetugasById(@PathVariable Integer id) {
        Petugas petugas = petugasService.getPetugasById(id);
        return new Response(
                petugas,
                petugas != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }
}
