/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoop.tablemodel;

import java.util.ArrayList;
import javaoop.entity.Mahasiswa;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fachr
 */
public class TableModelMahasiswa extends AbstractTableModel{
    
    private ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listMahasiswa.get(rowIndex).getNim();
            case 1: return listMahasiswa.get(rowIndex).getNama();
            case 2: return listMahasiswa.get(rowIndex).getAlamat();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "NIM";
            case 1: return "Nama";
            case 2: return "Alamat";
            default: return null;
        }
    }
    
    public void insertMahasiswa(Mahasiswa m){
        listMahasiswa.add(m);
        fireTableDataChanged();
    }
    
    public void updateMahasiswa(int index, Mahasiswa m){
        listMahasiswa.set(index, m);
        fireTableDataChanged();
    }
    
    public void deleteMahasiswa(int index){
        listMahasiswa.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<Mahasiswa> listMahasiswa){
        this.listMahasiswa = listMahasiswa;
        fireTableDataChanged();
    }
    
    public Mahasiswa getMahasiswa(int index){
        return listMahasiswa.get(index);
    }
    
    public void clear(){
        listMahasiswa.clear();
    }
    
    
    
    
    
}
