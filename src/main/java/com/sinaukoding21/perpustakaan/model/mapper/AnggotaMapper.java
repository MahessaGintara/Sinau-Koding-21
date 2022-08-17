package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.Anggota;
import com.sinaukoding21.perpustakaan.model.dto.AnggotaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnggotaMapper {
    AnggotaMapper INSTANCE = Mappers.getMapper(AnggotaMapper.class);

    Anggota toEntity(AnggotaDto dto);

    AnggotaDto toDto(Anggota entity);

    List<AnggotaDto> toListDto(List<Anggota> entities);

    List<Anggota> toListEntity(List<AnggotaDto> dtos);
}
