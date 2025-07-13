package com.poso.space.kasir;

import java.util.List;
import java.util.Scanner;

import com.poso.space.kasir.model.Produk;
import com.poso.space.kasir.service.ProdukService;
import com.poso.space.kasir.service.ProdukServiceImpl;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdukService produkService = new ProdukServiceImpl();

        while (true) {
            System.out.println("\n=== MENU PRODUK ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Update Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> {
                    Produk produk = new Produk();

                    System.out.print("Nama produk: ");
                    String nama = scanner.nextLine();

                    if (produkService.namaSudahTerdaftar(nama)) {
                        System.out.println("❌ Nama produk sudah terdaftar!");
                        break;
                    }

                    produk.setNama(nama);

                    System.out.print("Harga: ");
                    produk.setHarga(scanner.nextInt());

                    System.out.print("Stok: ");
                    produk.setStok(scanner.nextInt());
                    scanner.nextLine();

                    produkService.tambahProduk(produk);
                    System.out.println("✅ Produk berhasil ditambahkan.");
                }

                case 2 -> {
                    List<Produk> list = produkService.tampilSemuaProduk();
                    if (list.isEmpty()) {
                        System.out.println("(Belum ada produk)");
                    } else {
                        System.out.println("\n=== DAFTAR PRODUK ===");
                        for (Produk p : list) {
                            System.out.printf("%d. %s - Rp%d [%d stok]%n",
                                    p.getId(), p.getNama(), p.getHarga(), p.getStok());
                        }
                    }
                }

                case 3 -> {
                    System.out.print("ID produk yang ingin diupdate: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Produk p = produkService.cariId(id);
                    if (p == null) {
                        System.out.println("❌ Produk tidak ditemukan.");
                        break;
                    }

                    System.out.print("Nama baru [" + p.getNama() + "]: ");
                    String nama = scanner.nextLine();
                    if (!nama.isBlank()) {
                        if (!nama.equals(p.getNama()) && produkService.namaSudahTerdaftar(nama)) {
                            System.out.println("❌ Nama produk sudah terdaftar!");
                            break;
                        }
                        p.setNama(nama);
                    }

                    System.out.print("Harga baru [" + p.getHarga() + "]: ");
                    String hargaInput = scanner.nextLine();
                    if (!hargaInput.isBlank()) {
                        p.setHarga(Integer.parseInt(hargaInput));
                    }

                    System.out.print("Stok baru [" + p.getStok() + "]: ");
                    String stokInput = scanner.nextLine();
                    if (!stokInput.isBlank()) {
                        p.setStok(Integer.parseInt(stokInput));
                    }

                    produkService.ubahProduk(p);
                    System.out.println("✅ Produk berhasil diupdate.");
                }

                case 4 -> {
                    System.out.print("ID produk yang ingin dihapus: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Produk p = produkService.cariId(id);
                    if (p == null) {
                        System.out.println("❌ Produk tidak ditemukan.");
                    } else {
                        produkService.hapusProduk(id);
                        System.out.println("✅ Produk berhasil dihapus.");
                    }
                }

                case 0 -> {
                    System.out.println("👋 Keluar dari program.");
                    return;
                }

                default -> System.out.println("❌ Menu tidak valid.");
            }
        }
    }
}
