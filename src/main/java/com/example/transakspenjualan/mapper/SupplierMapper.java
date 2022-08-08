package com.example.transakspenjualan.mapper;


import com.example.transakspenjualan.dto.SupplierDTO;
import com.example.transakspenjualan.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    Supplier toEntity(SupplierDTO supplierDto);

    SupplierDTO toDto(Supplier supplier);

    List<SupplierDTO> toListDto(List<Supplier> all);
}
