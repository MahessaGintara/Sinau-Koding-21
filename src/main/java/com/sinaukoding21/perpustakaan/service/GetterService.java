package com.sinaukoding21.perpustakaan.service;

import com.sinaukoding21.perpustakaan.model.Buku;
import com.sinaukoding21.perpustakaan.model.dto.GetBukuDto;

import java.util.ArrayList;
import java.util.List;

public class GetterService {
    public static List<GetBukuDto> getBuku (List<Buku> buku){
        List<GetBukuDto> bukuList = new ArrayList<>();
        for (Buku value : buku) {
            GetBukuDto bukuModel = new GetBukuDto();
            bukuModel.setId(value.getId());
            bukuModel.setJudul(value.getJudul());
            bukuModel.setTahunTerbit(value.getTahunTerbit());
            bukuModel.setJumlah(value.getJumlah());
            bukuModel.setIsbn(value.getIsbn());
            bukuModel.setPengarang(value.getPengarang().getNama());
            bukuModel.setPenerbit(value.getPenerbit().getNama());
            bukuList.add(bukuModel);
        }
        return bukuList;
    }
}
