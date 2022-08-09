package com.example.transakspenjualan.controller;


import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.AuthRequestDTO;
import com.example.transakspenjualan.model.dto.RegistrationDTO;
import com.example.transakspenjualan.model.dto.UserDTO;
import com.example.transakspenjualan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/do-login")
    public Response doLogin(@RequestBody AuthRequestDTO param) {
        UserDTO data = userService.doLogin(param);

        return new Response(data, data != null ? "Login Sukses" : "Login gagal", HttpStatus.OK);
    }

    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDTO param){
        RegistrationDTO data = userService.doRegister(param);
        return new Response(data, data != null ? "Registrasi berhasil" : "Registrasi gagal", HttpStatus.OK);
    }
}
