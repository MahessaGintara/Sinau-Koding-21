package com.sinaukoding21.perpustakaan.enumeration;

import lombok.Getter;

public enum RoleUser {
    NONE("NONE"),
    ANGGOTA("ANGGOTA"),
    PETUGAS("PETUGAS"),
    ADMIN("ADMIN");

    @Getter
    private String name;
    RoleUser(String name) {
        this.name = name;
    }
}
