package com.example.transakspenjualan.mapper;

import com.example.transakspenjualan.dto.BarangDTO;
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
