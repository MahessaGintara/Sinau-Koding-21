package com.example.transakspenjualan.controller;


import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.TransaksiDTO;
import com.example.transakspenjualan.model.Transaksi;
import com.example.transakspenjualan.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping
    public Response getAllTransaksi() {

        return new Response(transaksiService.getAllTransaksi(), transaksiService.getAllTransaksi().size(), HttpStatus.OK);
    }

    @PostMapping
    public Response  createTransaksi(@RequestBody TransaksiDTO transaksi) {
        return new Response(transaksiService.createTransaksi(transaksi),"Data Berhasil Disimpan", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Response deleteTransaksi(@PathVariable Integer id) {
        if(transaksiService.deleteTransaksi(id)){
            return new Response("Data Berhasil Dihapus", HttpStatus.OK);
        }else {
            return new Response("Data Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaksi(@PathVariable Integer id,@RequestBody Transaksi transaksi) {
        return ResponseEntity.ok(transaksiService.updateTransaksi(id, transaksi));
    }

    @GetMapping("/find-by-id/{id}")
        public Response getTransaksiById(@PathVariable Integer id){
        return  new Response(transaksiService.getTransaksiById(id),"Data Berhasil Ditemukan", HttpStatus.OK);
    }
}