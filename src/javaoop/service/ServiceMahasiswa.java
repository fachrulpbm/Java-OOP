/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.service;

import javaoop.entity.Mahasiswa;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fachr
 */
public interface ServiceMahasiswa {
    
    public void insertMahasiswa(Mahasiswa m) throws SQLException;
    public void updateMahasiswa(Mahasiswa m) throws SQLException;
    public void deleteMahasiswa(Mahasiswa m) throws SQLException;
    public Mahasiswa getMahasiswaByNim(String nim) throws SQLException;
    public ArrayList<Mahasiswa> getMahasiswa() throws SQLException;
    
}
