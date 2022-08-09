package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.BarangDTO;
import com.example.transakspenjualan.model.Barang;
import com.example.transakspenjualan.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @GetMapping
    public Response getAllBarang() {
        return new Response(barangService.getAllBarang(), barangService.getAllBarang().size(), HttpStatus.OK);
    }

    @PostMapping
    public Response createBarang(@RequestBody BarangDTO barang) {
        return new Response(barangService.createBarang(barang), "Data Berhasil Disimpan", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id) {
        if (barangService.deleteBarang(id)){
            return new Response("Data Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Data Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBarang(@PathVariable Integer id,@RequestBody Barang barang) {
        return ResponseEntity.ok(barangService.updateBarang(id, barang));
    }

    @GetMapping("/find-by-id/{id}")
    public Response getBarangById(@PathVariable Integer id) {
        return new Response(barangService.getBarangById(id), "Data Berhasil Ditemukan", HttpStatus.OK);
    }
}
