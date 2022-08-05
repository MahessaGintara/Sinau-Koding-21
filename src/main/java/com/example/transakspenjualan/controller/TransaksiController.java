package com.example.transakspenjualan.controller;


import com.example.transakspenjualan.model.Transaksi;
import com.example.transakspenjualan.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping
    public ResponseEntity<?> getAllTransaksi() {
        return ResponseEntity.ok(transaksiService.getAllTransaksi());
    }

    @PostMapping
    public ResponseEntity<?>  createTransaksi(@RequestBody Transaksi transaksi) {
        return ResponseEntity.ok(transaksiService.createTransaksi(transaksi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaksi(@PathVariable Integer id) {
        transaksiService.deleteTransaksi(id);
        return ResponseEntity.ok("Transaksi berhasil dihapus");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaksi(@PathVariable Integer id,@RequestBody Transaksi transaksi) {
        return ResponseEntity.ok(transaksiService.updateTransaksi(id, transaksi));
    }
}
