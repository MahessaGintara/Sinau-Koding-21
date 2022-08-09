package com.example.transakspenjualan.repository;

import com.example.transakspenjualan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
