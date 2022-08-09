package com.example.transakspenjualan.controller;

import com.example.transakspenjualan.common.Response;
import com.example.transakspenjualan.model.dto.UserDTO;
import com.example.transakspenjualan.model.User;
import com.example.transakspenjualan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Response getAllUser() {
        return new Response(userService.getAllUser(), userService.getAllUser().size(), HttpStatus.OK);
    }

    @PostMapping
    public Response createUser(@RequestBody UserDTO user) {
        return new Response(userService.createUser(user), "Data Berhasil Disimpan", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Integer id) {
        if(userService.deleteUser(id)){
            return new Response("Data Berhasil Dihapus", HttpStatus.OK);
        }else {
            return new Response("Data Gagal Dihapus", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @GetMapping("/find-by-id/{id}")
    public Response getUserById(@PathVariable Integer id) {
        return new Response(userService.getUserById(id), "Data Berhasil Ditemukan", HttpStatus.OK);
    }

}
