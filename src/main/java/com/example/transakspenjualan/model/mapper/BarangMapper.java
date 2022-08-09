package com.example.transakspenjualan.model.mapper;

import com.example.transakspenjualan.model.dto.BarangDTO;
import com.example.transakspenjualan.model.Barang;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapper {
    BarangMapper INSTANCE = Mappers.getMapper(BarangMapper.class);

    Barang toEntity(BarangDTO barangDto);

    BarangDTO toDto(Barang barang);

    List<BarangDTO> toListDto(List<Barang> barangs);

    List<Barang> toListEntity(List<BarangDTO> barangDtos);
}
