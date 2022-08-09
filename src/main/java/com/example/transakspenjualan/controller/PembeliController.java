package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.PembeliDTO;
import com.example.transakspenjualan.model.Pembeli;
import com.example.transakspenjualan.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;

    @GetMapping
    public Response getAllPembeli() {
        return new Response(pembeliService.getAllPembeli(), pembeliService.getAllPembeli().size(), HttpStatus.OK);
    }

    @PostMapping
    public Response createPembeli(@RequestBody PembeliDTO pembeli) {
        return new Response(pembeliService.createPembeli(pembeli), "Data Berhasil Disimpan", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Response deletePembeli(@PathVariable Integer id) {
        if (pembeliService.deletePembeli(id)){
            return new Response("Data Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Data Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembeli(@PathVariable Integer id,@RequestBody Pembeli pembeli) {
        return ResponseEntity.ok(pembeliService.updatePembeli(id, pembeli));
    }

    @GetMapping("/find-by-id/{id}")
    public Response getPembeliById(@PathVariable Integer id) {
        return new Response(pembeliService.getPembeliById(id), "Data Berhasil Ditemukan", HttpStatus.OK);
    }
}
