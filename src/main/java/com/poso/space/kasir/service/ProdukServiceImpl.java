package com.poso.space.kasir.service;

import java.util.List;

import com.poso.space.kasir.model.Produk;
import com.poso.space.kasir.repository.PordukRepository;
import com.poso.space.kasir.repository.ProdukRepositoryImpl;

public class ProdukServiceImpl implements ProdukService {

    private final PordukRepository produkRepository;

    public ProdukServiceImpl() {
        this.produkRepository = new ProdukRepositoryImpl();
    }

    @Override
    public List<Produk> findAll() {
        return produkRepository.findAllProduks();
    }

    @Override
    public Produk findById(int id) {
        return produkRepository.findById(id);
    }

    @Override
    public void hapusProduk(int id) {
        produkRepository.delete(id);

    }

    @Override
    public boolean namaSudahTerdaftar(String nama) {
        return produkRepository.existsByNama(nama);
    }

    @Override
    public void tambahProduk(Produk produk) {
        produkRepository.insert(produk);

    }

    @Override
    public void ubahProduk(Produk produk) {
        produkRepository.update(produk);

    }

}
