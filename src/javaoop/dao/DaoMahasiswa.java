/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.dao;

import com.mysql.jdbc.Connection;
import javaoop.config.Koneksi;
import javaoop.entity.Mahasiswa;
import javaoop.service.ServiceMahasiswa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fachr DAO = Data Access Object
 */
public class DaoMahasiswa implements ServiceMahasiswa {

    private Connection connection;

    public DaoMahasiswa() throws SQLException {
        connection = Koneksi.getConnection();
    }

    @Override
    public void insertMahasiswa(Mahasiswa m) throws SQLException {
        PreparedStatement st = null;
        String sql = "INSERT INTO mahasiswa VALUE(?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, m.getNim());
            st.setString(2, m.getNama());
            st.setString(3, m.getAlamat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public void updateMahasiswa(Mahasiswa m) throws SQLException {
        PreparedStatement st = null;
        String sql = "UPDATE mahasiswa SET nama=?, alamat=? WHERE nim=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, m.getNama());
            st.setString(2, m.getAlamat());
            st.setString(3, m.getNim());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public void deleteMahasiswa(Mahasiswa m) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM mahasiswa WHERE nim=?";

        try {
            st = connection.prepareCall(sql);
            st.setString(1, m.getNim());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }

    @Override
    public Mahasiswa getMahasiswaByNim(String nim) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Mahasiswa m = null;
        String sql = "SELECT * FROM mahasiswa WHERE nim=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, nim);
            rs = st.executeQuery();
            while (rs.next()) {
                m = new Mahasiswa();
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setAlamat(rs.getString("alamat"));
            }
            return m;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    @Override
    public ArrayList<Mahasiswa> getMahasiswa() throws SQLException {
        PreparedStatement st = null;
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM mahasiswa";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setAlamat(rs.getString("alamat"));
                listMahasiswa.add(m);
            }
            return listMahasiswa;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }

}
