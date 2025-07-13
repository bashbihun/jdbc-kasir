package com.poso.space.kasir.service;

import java.util.List;

import com.poso.space.kasir.model.Produk;

public interface ProdukService {

    void tambahProduk(Produk produk);

    void ubahProduk(Produk produk);

    void hapusProduk(int id);

    Produk cariId(int id);

    List<Produk> tampilSemuaProduk();

    boolean namaSudahTerdaftar(String nama);
}
