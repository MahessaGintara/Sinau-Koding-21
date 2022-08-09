package com.example.transakspenjualan.service;


import com.example.transakspenjualan.dto.SupplierDTO;
import com.example.transakspenjualan.mapper.SupplierMapper;
import com.example.transakspenjualan.model.Supplier;
import com.example.transakspenjualan.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierDTO> getAllSupplier() {
        return SupplierMapper.INSTANCE.toListDto(supplierRepository.findAll());
    }

    public SupplierDTO createSupplier(SupplierDTO supplier) {
        Supplier supplier1 = SupplierMapper.INSTANCE.toEntity(supplier);
        supplier1 = supplierRepository.save(supplier1);
        return SupplierMapper.INSTANCE.toDto(supplier1);
    }

    public boolean deleteSupplier(Integer id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(null);
        supplierRepository.delete(supplier);

        try {
            supplierRepository.delete(supplier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Supplier updateSupplier(Integer id, Supplier supplier) {
        Supplier supplierToUpdate = supplierRepository.findById(id).get();
        supplierToUpdate.setNamaSupplier(supplier.getNamaSupplier() != null ? supplier.getNamaSupplier() : supplierToUpdate.getNamaSupplier());
        supplierToUpdate.setNoTelp(supplier.getNoTelp() != null ? supplier.getNoTelp() : supplierToUpdate.getNoTelp());
        supplierToUpdate.setAlamat(supplier.getAlamat() != null ? supplier.getAlamat() : supplierToUpdate.getAlamat());
        return supplierRepository.save(supplierToUpdate);
    }

    public SupplierDTO getSupplierById(Integer id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(null);
        return SupplierMapper.INSTANCE.toDto(supplier);
    }
}
