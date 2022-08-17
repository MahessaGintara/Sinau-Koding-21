package com.sinaukoding21.perpustakaan.model.mapper;

import com.sinaukoding21.perpustakaan.model.User;
import com.sinaukoding21.perpustakaan.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    List<UserDto> toListDto(List<User> entities);

    List<User> toListEntity(List<UserDto> dtos);

    RegistrationDto toRegistrationDto(User user);

    User toUserFromRegistrationDto(RegistrationDto registrationDto);

    AuthResponseDto toAuthResponseDto(User user);

    User toUserFromUserAnggoata(UserAnggotaDto param);

    UserAnggotaDto toUserAnggotaDto(User user);

    User toUserFromUserPetugasDto(UserPetugasDto param);

    UserPetugasDto toUserPetugasDto(User user);
}
