package com.sinaukoding21.perpustakaan.repository;

import com.sinaukoding21.perpustakaan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
