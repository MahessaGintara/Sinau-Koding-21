package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Petugas;
import com.sinaukoding21.perpustakaan.model.dto.PetugasDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PetugasMapper {
    PetugasMapper INSTANCE = Mappers.getMapper(PetugasMapper.class);

    Petugas toEntity(PetugasDto dto);

    PetugasDto toDto(Petugas entity);

    List<PetugasDto> toListDto(List<Petugas> entities);

    List<Petugas> toListEntity(List<PetugasDto> dtos);
}
