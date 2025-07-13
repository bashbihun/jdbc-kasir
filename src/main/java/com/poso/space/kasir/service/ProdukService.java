package com.poso.space.kasir.service;

import java.util.List;

import com.poso.space.kasir.model.Produk;

public interface ProdukService {

    void tambahProduk(Produk produk);

    void ubahProduk(Produk produk);

    void hapusProduk(int id);

    Produk findById(int id);

    List<Produk> findAll();

    boolean namaSudahTerdaftar(String nama);
}
