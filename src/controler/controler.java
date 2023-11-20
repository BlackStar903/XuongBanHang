/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GioHang;
import model.SanPham;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class controler {

    private final List<SanPham> listSp = new ArrayList<>();
    public List<GioHang> listGioHang = new ArrayList<>();

    private Connection openConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost;databaseName=ASM_SOF203;user=sa;password=1234";
        return DriverManager.getConnection(url);
    }

    public List<SanPham> getDataFromDb() {
        try {
            Statement sta = openConnection().createStatement();
            String query = "Select * from SanPham";
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {                
                listSp.add(new SanPham(rs.getString(2), rs.getString(3), "2023", "12kg", "abc", rs.getInt(4), 0, rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSp;
    }

    public List<GioHang> getProduct(int value, int index) {
        SanPham sp = listSp.get(index);
        GioHang newSp = new GioHang(sp.getIdSP(), sp.getTenSp(), sp.getGiaBan(), value * sp.getGiaBan(), value);
        if (value > sp.getSoLuong() || value < 1) {
            JOptionPane.showMessageDialog(null, "So luong mua can khong hop le");
        } else {
            for (SanPham spc : listSp) {
                if (spc.getIdSP().equals(newSp.getMaSp())) {
                    if (sp.getSoLuong() > 0) {
                        sp.setSoLuong(sp.getSoLuong() - value);
                        boolean check = true;
                        for (GioHang gioHang : listGioHang) {
                            if (gioHang.getMaSp().equals(newSp.getMaSp())) {
                                gioHang.setSoLuong(gioHang.getSoLuong() + value);
                                gioHang.setThanhTien(gioHang.getSoLuong() * gioHang.getDonGia());
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            listGioHang.add(newSp);
                        }
                    }
                }
            }
        }
        return listGioHang;
    }

    public List<GioHang> removeProduct(int value, int index) {
        if (value < 0 || value > listGioHang.get(index).getSoLuong()) {
            JOptionPane.showMessageDialog(null, "So luong mua can khong hop le");
        } else if (value == 0) {
            listGioHang.remove(index);
        } else {
            GioHang gh = listGioHang.get(index);
            for (SanPham sp : listSp) {
                if (sp.getIdSP().equals(gh.getMaSp())) {
                    sp.setSoLuong(sp.getSoLuong() + gh.getSoLuong() - value);
                }
            }
            gh.setSoLuong(value);
            gh.setThanhTien(gh.getThanhTien() * value);
        }
        return listGioHang;
    }
    
    public void createBill(){
        
    }
}
