package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.SupplierDTO;
import com.example.transakspenjualan.model.Supplier;
import com.example.transakspenjualan.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public Response getAllSupplier() {
        return new Response(supplierService.getAllSupplier(),supplierService.getAllSupplier().size(), HttpStatus.OK);
    }

    @PostMapping
    public Response createSupplier(@RequestBody SupplierDTO supplier) {
        return new Response(supplierService.createSupplier(supplier), "Data Berhasil Disimpan", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Response deleteSupplier(@PathVariable Integer id) {
        if (supplierService.deleteSupplier(id)){
            return new Response("Data Berhasil Dihapus", HttpStatus.OK);
        } else {
            return new Response("Data Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
    }

    @GetMapping("/find-by-id/{id}")
    public Response getSupplierById(@PathVariable Integer id) {
        return new Response(supplierService.getSupplierById(id), "Data Berhasil Ditemukan", HttpStatus.OK);
    }
}
