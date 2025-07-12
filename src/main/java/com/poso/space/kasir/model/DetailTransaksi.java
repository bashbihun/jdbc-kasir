package com.poso.space.kasir.model;

public class DetailTransaksi {

    private int id;
    private int transaksiId;
    private Produk produk;
    private int jumlah;
    private int subtotal;

    public DetailTransaksi() {

    }

    public DetailTransaksi(int id, int transaksiId, Produk produk, int jumlah, int subtotal) {
        this.id = id;
        this.transaksiId = transaksiId;
        this.produk = produk;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksi(int transaksiId) {
        this.transaksiId = transaksiId;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
