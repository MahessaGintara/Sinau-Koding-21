package com.example.transakspenjualan.service;


import com.example.transakspenjualan.model.Supplier;
import com.example.transakspenjualan.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier createSupplier(Supplier supplier) {
        Supplier supplier1 = supplier;
        supplier1 = supplierRepository.save(supplier1);
        return supplier1;
    }

    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }

    public Supplier updateSupplier(Integer id, Supplier supplier) {
        Supplier supplierToUpdate = supplierRepository.findById(id).get();
        supplierToUpdate.setNamaSupplier(supplier.getNamaSupplier() != null ? supplier.getNamaSupplier() : supplierToUpdate.getNamaSupplier());
        supplierToUpdate.setNoTelp(supplier.getNoTelp() != null ? supplier.getNoTelp() : supplierToUpdate.getNoTelp());
        supplierToUpdate.setAlamat(supplier.getAlamat() != null ? supplier.getAlamat() : supplierToUpdate.getAlamat());
        return supplierRepository.save(supplierToUpdate);
    }
}
