package com.example.transakspenjualan.service;

import com.example.transakspenjualan.config.JwtTokenUtil;
import com.example.transakspenjualan.model.dto.AuthRequestDTO;
import com.example.transakspenjualan.model.dto.RegistrationDTO;
import com.example.transakspenjualan.model.dto.UserDTO;
import com.example.transakspenjualan.model.mapper.UserMapper;
import com.example.transakspenjualan.model.User;
import com.example.transakspenjualan.repository.UserRepository;
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
    JwtTokenUtil jwtTokenUtil;

    public List<UserDTO> getAllUser(){
        return UserMapper.INSTANCE.toListDto(userRepository.findAll());
    }

    public UserDTO createUser(UserDTO user){
        User user1 = UserMapper.INSTANCE.toEntity(user);
        user1 = userRepository.save(user1);
        return UserMapper.INSTANCE.toDto(user1);
    }

    public boolean deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(null);
        userRepository.delete(user);

        try {
            userRepository.delete(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public User updateUser(Integer id, User user) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setUsername(user.getUsername() != null ? user.getUsername() : userToUpdate.getUsername());
        userToUpdate.setPassword(user.getUsername() != null ? user.getPassword() : userToUpdate.getPassword());
        userToUpdate.setNoTelp(user.getNoTelp() != null ? user.getNoTelp() : userToUpdate.getNoTelp());
        return userRepository.save(userToUpdate);
    }

    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(null);
        return UserMapper.INSTANCE.toDto(user);
    }

    public UserDTO doLogin(AuthRequestDTO user){
        User currentUser = userRepository.findByUsername(user.getUsername());

        if (currentUser == null){
            return UserMapper.INSTANCE.toDto(currentUser);
        } else if (currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());
            currentUser.setToken(jwtTokenUtil.doGenerateToken(userDetails));
            return UserMapper.INSTANCE.toDto(currentUser);
        }
        return null;
    }

    public RegistrationDTO doRegister(RegistrationDTO param){
        User user = userRepository.findByUsername(param.getUsername());

        if (user != null){
            return null;
        }
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        user = userRepository.save(UserMapper.INSTANCE.toUserFromRegistationDTO(param));

        return UserMapper.INSTANCE.toRegistrationDto(user);
    }

}
