package com.example.transakspenjualan.model.mapper;


import com.example.transakspenjualan.model.dto.PembeliDTO;
import com.example.transakspenjualan.model.Pembeli;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapper {

    PembeliMapper INSTANCE = Mappers.getMapper(PembeliMapper.class);

    Pembeli toEntity(PembeliDTO pembeliDto);

    PembeliDTO toDto(Pembeli pembeli);

    List<Pembeli> toListEntity(List<Pembeli> all);
}
