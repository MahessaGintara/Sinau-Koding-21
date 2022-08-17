package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Pengarang;
import com.sinaukoding21.perpustakaan.model.dto.PengarangDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengarangMapper {
    PengarangMapper INSTANCE = Mappers.getMapper(PengarangMapper.class);

    Pengarang toEntity(PengarangDto dto);

    PengarangDto toDto(Pengarang entity);

    List<PengarangDto> toListDto(List<Pengarang> entities);

    List<Pengarang> toListEntity(List<PengarangDto> dtos);
}
