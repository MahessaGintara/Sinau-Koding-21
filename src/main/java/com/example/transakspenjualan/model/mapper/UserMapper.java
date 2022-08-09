package com.example.transakspenjualan.model.mapper;

import com.example.transakspenjualan.model.dto.RegistrationDTO;
import com.example.transakspenjualan.model.dto.UserDTO;
import com.example.transakspenjualan.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);

    User toEntity(UserDTO userDto);

    List<UserDTO> toListDto(List<User> users);

    List<User> toListEntity(List<UserDTO> userDtos);

    User toUserFromRegistationDTO(RegistrationDTO param);

    RegistrationDTO toRegistrationDto(User user);
}
