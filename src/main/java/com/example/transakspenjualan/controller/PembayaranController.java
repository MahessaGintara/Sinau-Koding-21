package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.PembayaranDTO;
import com.example.transakspenjualan.model.Pembayaran;
import com.example.transakspenjualan.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {

    @Autowired
    PembayaranService pembayaranService;

    @GetMapping
    public Response getAllPembayaran() {
        return new Response(pembayaranService.getAllPembayaran(),pembayaranService.getAllPembayaran().size(), HttpStatus.OK);
    }

    @PostMapping
    public Response createPembayaran(@RequestBody PembayaranDTO pembayaran) {
        return new Response(pembayaranService.createPembayaran(pembayaran), "Data Berhasil Disimpan", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Response deletePembayaran(@PathVariable Integer id) {
        if(pembayaranService.deletePembayaran(id)){
            return new Response("Data Berhasil Dihapus", HttpStatus.OK);
        }else {
            return new Response("Data Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembayaran(@PathVariable Integer id,@RequestBody Pembayaran pembayaran) {
        return ResponseEntity.ok(pembayaranService.updatePembayaran(id, pembayaran));
    }

    @GetMapping("/find-by-id/{id}")
    public Response getPembayaranById(@PathVariable Integer id) {
        return new Response(pembayaranService.getPembayaranById(id), "Data Berhasil Ditemukan", HttpStatus.OK);
    }

}
