package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.dto.PembeliDTO;
import com.example.transakspenjualan.model.Pembeli;
import com.example.transakspenjualan.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;

    @GetMapping
    public ResponseEntity<?> getAllPembeli() {
        return ResponseEntity.ok(pembeliService.getAllPembeli());
    }

    @PostMapping
    public ResponseEntity<?> createPembeli(@RequestBody PembeliDTO pembeli) {
        return ResponseEntity.ok(pembeliService.createPembeli(pembeli));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePembeli(@PathVariable Integer id) {
        pembeliService.deletePembeli(id);
        return ResponseEntity.ok("Pembeli berhasil dihapus");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembeli(@PathVariable Integer id,@RequestBody Pembeli pembeli) {
        return ResponseEntity.ok(pembeliService.updatePembeli(id, pembeli));
    }
}
