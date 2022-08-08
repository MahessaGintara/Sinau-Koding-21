package com.example.transakspenjualan.mapper;

import com.example.transakspenjualan.dto.TransaksiDTO;
import com.example.transakspenjualan.model.Transaksi;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapper {
    TransaksiMapper INSTANCE = Mappers.getMapper(TransaksiMapper.class);

    Transaksi toEntity(TransaksiDTO transaksiDto);

    TransaksiDTO toDto(Transaksi transaksi1);

    List<TransaksiDTO> toListDto(List<Transaksi> transaksis);

    List<Transaksi> toListEntity(List<TransaksiDTO> transaksiDtos);

}
