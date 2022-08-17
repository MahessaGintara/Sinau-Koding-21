package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Buku;
import com.sinaukoding21.perpustakaan.model.dto.BukuDto;
import com.sinaukoding21.perpustakaan.model.dto.UpdateBukuDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BukuMapper {
    BukuMapper INSTANCE = Mappers.getMapper(BukuMapper.class);

    Buku toEntity(BukuDto dto);

    BukuDto toDto(Buku entity);

    List<BukuDto> toListDto(List<Buku> entities);

    List<Buku> toListEntity(List<BukuDto> dtos);
}
