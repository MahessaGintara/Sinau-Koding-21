package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.dto.BarangDTO;
import com.example.transakspenjualan.model.Barang;
import com.example.transakspenjualan.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @GetMapping
    public ResponseEntity<?> getAllBarang() {
        return ResponseEntity.ok(barangService.getAllBarang());
    }

    @PostMapping
    public ResponseEntity<?> createBarang(@RequestBody BarangDTO barang) {
        return ResponseEntity.ok(barangService.createBarang(barang));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarang(@PathVariable Integer id) {
        barangService.deleteBarang(id);
        return ResponseEntity.ok("Barang berhasil dihapus");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBarang(@PathVariable Integer id,@RequestBody Barang barang) {
        return ResponseEntity.ok(barangService.updateBarang(id, barang));
    }
}
