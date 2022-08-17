package com.sinaukoding21.perpustakaan.controller;

import com.sinaukoding21.perpustakaan.common.Response;
import com.sinaukoding21.perpustakaan.model.User;
import com.sinaukoding21.perpustakaan.model.dto.UserAnggotaDto;
import com.sinaukoding21.perpustakaan.model.dto.UserDto;
import com.sinaukoding21.perpustakaan.model.dto.UserPetugasDto;
import com.sinaukoding21.perpustakaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response getAllUser() {
        return new Response(
                userService.getAllUser(),
                userService.getAllUser().size(),
                HttpStatus.OK
        );
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response createUser(@RequestBody UserDto user) {
        return new Response(
                userService.createUser(user),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @PostMapping("/with-anggota")
    @PreAuthorize("hasAnyAuthority('PETUGAS','ADMIN')")
    public Response createUserAnggota(@RequestBody UserAnggotaDto user) {
        return new Response(
                userService.createUserAnggota(user),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @PostMapping("/with-petugas")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response createUser(@RequestBody UserPetugasDto user) {
        return new Response(
                userService.createUserPetugas(user),
                "Data Berhasil Ditambahkan",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.ok("User Berhasil Dihapus");
        } else {
            return ResponseEntity.badRequest().body("User Gagal Dihapus");
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PETUGAS', 'ADMIN')")
    public Response updateUser(@PathVariable Integer id, @RequestBody User user) {
        return new Response(
                userService.updateUser(id, user),
                "Data Berhasil Diubah",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ANGGOTA','PETUGAS', 'ADMIN')")
    public Response getUserById(@PathVariable Integer id) {
        UserDto user = userService.getUserById(id);
        return new Response(
                user,
                user != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }
}
