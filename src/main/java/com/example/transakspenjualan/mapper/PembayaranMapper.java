package com.example.transakspenjualan.mapper;

import com.example.transakspenjualan.dto.PembayaranDTO;
import com.example.transakspenjualan.model.Pembayaran;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapper {
    PembayaranMapper INSTANCE = Mappers.getMapper(PembayaranMapper.class);

    Pembayaran toEntity(PembayaranDTO pembayaranDto);

    PembayaranDTO toDto(Pembayaran pembayaran);

    List<PembayaranDTO> toListDto(List<Pembayaran> pembayarans);
}
