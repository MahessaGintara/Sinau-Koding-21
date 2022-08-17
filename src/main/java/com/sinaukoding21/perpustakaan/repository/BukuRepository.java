package com.sinaukoding21.perpustakaan.repository;

import com.sinaukoding21.perpustakaan.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
    @Query(value = "SELECT * FROM buku WHERE judul LIKE %?1%", nativeQuery = true)
    List<Buku> findByJudul(String name);
}
