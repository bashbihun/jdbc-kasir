package com.poso.space.kasir.model;

import java.time.LocalDateTime;
import java.util.List;

public class Transaksi {

    private int id;
    private LocalDateTime tanggal;
    private int total;
    private List<DetailTransaksi> items;

    public Transaksi() {

    }

    public Transaksi(int id, LocalDateTime tanggal, int total, List<DetailTransaksi> items) {
        this.id = id;
        this.tanggal = tanggal;
        this.total = total;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DetailTransaksi> getItems() {
        return items;
    }

    public void setItems(List<DetailTransaksi> items) {
        this.items = items;
    }
}
