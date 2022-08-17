package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Peminjaman;
import com.sinaukoding21.perpustakaan.model.dto.PeminjamanDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanMapper {
    PeminjamanMapper INSTANCE = Mappers.getMapper(PeminjamanMapper.class);

    Peminjaman toEntity(PeminjamanDto dto);

    PeminjamanDto toDto(Peminjaman entity);

    List<PeminjamanDto> toListDto(List<Peminjaman> entities);

    List<Peminjaman> toListEntity(List<PeminjamanDto> dtos);
}
