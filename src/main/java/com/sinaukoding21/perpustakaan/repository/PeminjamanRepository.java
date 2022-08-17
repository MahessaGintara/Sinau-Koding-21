package com.sinaukoding21.perpustakaan.repository;

import com.sinaukoding21.perpustakaan.model.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Integer> {

}
