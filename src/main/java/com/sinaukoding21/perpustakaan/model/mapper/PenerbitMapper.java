package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Penerbit;
import com.sinaukoding21.perpustakaan.model.dto.PenerbitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PenerbitMapper {
    PenerbitMapper INSTANCE = Mappers.getMapper(PenerbitMapper.class);

    Penerbit toEntity(PenerbitDto dto);

    PenerbitDto toDto(Penerbit entity);

    List<PenerbitDto> toListDto(List<Penerbit> entities);

    List<Penerbit> toListEntity(List<PenerbitDto> dtos);
}
