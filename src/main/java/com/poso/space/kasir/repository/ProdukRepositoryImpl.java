package com.poso.space.kasir.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poso.space.kasir.config.DatabaseConnection;
import com.poso.space.kasir.model.Produk;

public class ProdukRepositoryImpl implements PordukRepository {

    @Override
    public void delete(int id) {
        String sql = "delete from produk where id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("gagal menghapus produk " + e.getMessage());
        }

    }

    @Override
    public boolean existsByNama(String nama) {
        String sql = "select count(*) from produk where nama = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nama);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("gagal cek nama produk " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Produk> findAllProduks() {
        List<Produk> produkList = new ArrayList<>();
        String sql = "select *from produk order by id";

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Produk produk = new Produk();
                produk.setId(resultSet.getInt("id"));
                produk.setNama(resultSet.getString("nama"));
                produk.setHarga(resultSet.getInt("harga"));
                produk.setStok(resultSet.getInt("stok"));
                produkList.add(produk);
            }

        } catch (SQLException e) {
            System.out.println("gagal mengambil semua produk " + e.getMessage());
        }
        return produkList;
    }

    @Override
    public Produk findById(int id) {
        String sql = "select *from produk whwere id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Produk produk = new Produk();
                produk.setId(resultSet.getInt("id"));
                produk.setNama(resultSet.getString("nama"));
                produk.setHarga(resultSet.getInt("harga"));
                produk.setStok(resultSet.getInt("stok"));
                return produk;
            }

        } catch (SQLException e) {
            System.out.println("gagal mengambil data produk dari id " + e.getMessage());
        }
        return null;
    }

    @Override
    public void insert(Produk produk) {
        String sql = "insert into produk(nama, harga, stok) values(?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, produk.getNama());
            preparedStatement.setInt(2, produk.getHarga());
            preparedStatement.setInt(3, produk.getStok());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("gagal menambah produk " + e.getMessage());
        }

    }

    @Override
    public void update(Produk produk) {
        String sql = "update produk set nama = ?, harga = ?, stok = ? where id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, produk.getNama());
            preparedStatement.setInt(2, produk.getHarga());
            preparedStatement.setInt(3, produk.getStok());
            preparedStatement.setInt(4, produk.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("gagal update produk " + e.getMessage());
        }
    }

}
