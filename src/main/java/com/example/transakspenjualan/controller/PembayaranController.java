package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.model.Pembayaran;
import com.example.transakspenjualan.service.PembayaranService;
import com.example.transakspenjualan.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {

    @Autowired
    PembayaranService pembayaranService;

    @GetMapping
    public ResponseEntity<?> getAllPembayaran() {
        return ResponseEntity.ok(pembayaranService.getAllPembayaran());
    }

    @PostMapping
    public ResponseEntity<?> createPembayaran(@RequestBody Pembayaran pembayaran) {
        return ResponseEntity.ok(pembayaranService.createPembayaran(pembayaran));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePembayaran(@PathVariable Integer id) {
        pembayaranService.deletePembayaran(id);
        return ResponseEntity.ok("Pembayaran berhasil dihapus");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembayaran(@PathVariable Integer id,@RequestBody Pembayaran pembayaran) {
        return ResponseEntity.ok(pembayaranService.updatePembayaran(id, pembayaran));
    }

}
