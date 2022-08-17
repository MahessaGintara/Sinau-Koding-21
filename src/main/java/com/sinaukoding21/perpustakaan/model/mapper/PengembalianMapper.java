package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Pengembalian;
import com.sinaukoding21.perpustakaan.model.dto.PengembalianDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianMapper {
    PengembalianMapper INSTANCE = Mappers.getMapper(PengembalianMapper.class);

    Pengembalian toEntity(PengembalianDto dto);

    PengembalianDto toDto(Pengembalian entity);

    List<PengembalianDto> toListDto(List<Pengembalian> entities);

    List<Pengembalian> toListEntity(List<PengembalianDto> dtos);
}
