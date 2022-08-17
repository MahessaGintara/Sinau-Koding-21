package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.Penerbit;
import com.sinaukoding21.perpustakaan.model.dto.PenerbitDto;
import com.sinaukoding21.perpustakaan.service.PenerbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penerbit")
public class PenerbitController {
    @Autowired
    PenerbitService penerbitService;

    @GetMapping
    public Response getAllPenerbit() {
        return new Response(
                penerbitService.getAllPenerbit(),
                penerbitService.getAllPenerbit().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public Response createPenerbit(@RequestBody PenerbitDto penerbit) {
        return new Response(
                penerbitService.createPenerbit(penerbit),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public Response deletePenerbit(@PathVariable Integer id) {
        if (penerbitService.deletePenerbit(id)) {
            return new Response("Penerbit Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Penerbit Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Response updatePenerbit(@PathVariable Integer id, @RequestBody Penerbit penerbit) {
        return new Response(
                penerbitService.updatePenerbit(id, penerbit),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Response getPenerbitById(@PathVariable Integer id) {
        Penerbit penerbit = penerbitService.getPenerbitById(id);
        return new Response(
                penerbit,
                penerbit != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }
}
