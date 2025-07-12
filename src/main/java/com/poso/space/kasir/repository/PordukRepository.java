package com.poso.space.kasir.repository;

import java.util.List;

import com.poso.space.kasir.model.Produk;

public interface PordukRepository {

    void insert(Produk produk);

    void update(Produk produk);

    void delete(int id);

    Produk findById(int id);

    List<Produk> findAllProduks();

    boolean existsByNama(String nama);
}
