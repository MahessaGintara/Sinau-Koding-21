package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.dto.AuthRequestDto;
import com.sinaukoding21.perpustakaan.model.dto.AuthResponseDto;
import com.sinaukoding21.perpustakaan.model.dto.RegistrationDto;
import com.sinaukoding21.perpustakaan.service.UserService;
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
    public Response doLogin(@RequestBody AuthRequestDto param){
        AuthResponseDto data = userService.doLogin(param);

        return new Response(
                data,
                data != null ? "Login Sukses": "Login Gagal",
                HttpStatus.OK
        );
    }

    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDto param){
        AuthResponseDto data = userService.doRegister(param);

        return new Response(
                data,
                data != null ? "Register Sukses": "Register Gagal",
                HttpStatus.OK
        );
    }
}
