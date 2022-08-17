package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.config.JwtTokenUtil;
import com.sinaukoding21.perpustakaan.enumeration.RoleUser;
import com.sinaukoding21.perpustakaan.model.Anggota;
import com.sinaukoding21.perpustakaan.model.Petugas;
import com.sinaukoding21.perpustakaan.model.User;
import com.sinaukoding21.perpustakaan.model.dto.*;
import com.sinaukoding21.perpustakaan.model.mapper.UserMapper;
import com.sinaukoding21.perpustakaan.repository.AnggotaRepository;
import com.sinaukoding21.perpustakaan.repository.PetugasRepository;
import com.sinaukoding21.perpustakaan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AnggotaRepository anggotaRepository;

    @Autowired
    PetugasRepository petugasRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public List<UserDto> getAllUser() {
        return UserMapper.INSTANCE.toListDto(userRepository.findAll());
    }

    public UserDto createUser(UserDto user) {

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        User userToCreate = UserMapper.INSTANCE.toEntity(user);
        userToCreate = userRepository.save(userToCreate);
        Anggota anggotaToUpdate = userToCreate.getAnggota();
        if (anggotaToUpdate != null) {
            anggotaToUpdate.setUser(userToCreate);
            anggotaRepository.save(anggotaToUpdate);
        }
        Petugas petugasToUpdate = userToCreate.getPetugas();
        if (petugasToUpdate != null) {
            petugasToUpdate.setUser(userToCreate);
            petugasRepository.save(petugasToUpdate);
        }
        return UserMapper.INSTANCE.toDto(userToCreate);
    }

    public boolean deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(null);
        userRepository.delete(user);

        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User updateUser(Integer id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(null);
        userToUpdate.setUsername(user.getUsername() != null ? user.getUsername() : userToUpdate.getUsername());
        userToUpdate.setEmail(user.getEmail() != null ? user.getEmail() : userToUpdate.getEmail());
        userToUpdate.setRole(user.getRole() != null ? user.getRole() : userToUpdate.getRole());
        return userRepository.save(userToUpdate);
    }



    public UserDto getUserById(Integer id) {
        return UserMapper.INSTANCE.toDto(userRepository.findById(id).orElseThrow(null));
    }

    public AuthResponseDto doLogin(AuthRequestDto user){
        User currentUser = userRepository.findByUsername(user.getUsername());

        if (currentUser == null){
            return UserMapper.INSTANCE.toAuthResponseDto(currentUser);
        }else if (currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
            // UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            currentUser.setToken(jwtTokenUtil.doGenerateToken(currentUser));

            return UserMapper.INSTANCE.toAuthResponseDto(currentUser);
        }
        return null;
    }

    public AuthResponseDto doRegister(RegistrationDto param){
        User user = userRepository.findByUsername(param.getUsername());
        if (user != null){
            return null;
        }
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        user = userRepository.save(UserMapper.INSTANCE.toUserFromRegistrationDto(param));
        //RegistrationDto registrationDto = param;
        //UserDetails userDetails = new org.springframework.security.core.userdetails.User(param.getUsername(), param.getPassword(), new ArrayList<>());
        user.setToken(jwtTokenUtil.doGenerateToken(user));
        return UserMapper.INSTANCE.toAuthResponseDto(user);
    }

    public UserAnggotaDto createUserAnggota(UserAnggotaDto user) {

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setRole(RoleUser.ANGGOTA);

        User userToCreate = UserMapper.INSTANCE.toUserFromUserAnggoata(user);
        userToCreate = userRepository.save(userToCreate);

        Anggota anggotaToUpdate = userToCreate.getAnggota();
        if (anggotaToUpdate != null) {
            anggotaToUpdate.setUser(userToCreate);
            anggotaRepository.save(anggotaToUpdate);
        }
        return UserMapper.INSTANCE.toUserAnggotaDto(userToCreate);
    }

    public UserPetugasDto createUserPetugas(UserPetugasDto user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setRole(RoleUser.PETUGAS);

        User userToCreate = UserMapper.INSTANCE.toUserFromUserPetugasDto(user);
        userToCreate = userRepository.save(userToCreate);

        Petugas petugasToUpdate = userToCreate.getPetugas();
        if (petugasToUpdate != null) {
            petugasToUpdate.setUser(userToCreate);
            petugasRepository.save(petugasToUpdate);
        }
        return UserMapper.INSTANCE.toUserPetugasDto(userToCreate);
    }
}

