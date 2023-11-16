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

/**
 *
 * @author Admin
 */
public class controler {
    
    List<SanPham> listSp = new ArrayList<>();
    public List<GioHang> listGioHang = new ArrayList<>();
    
    public List<SanPham> fakeData() {
        listSp.add(new SanPham("SP1", "Ban", "2023", "5kg", "Ban nhap khau", 19, 1000000, 1200000));
        listSp.add(new SanPham("SP2", "Ghe", "2022", "2kg", "Ghe hang viet nam", 30, 100000, 120000));
        listSp.add(new SanPham("SP3", "Tu", "2021", "10kg", "Tu nhap khau", 21, 1000000, 1300000));
        listSp.add(new SanPham("SP4", "Tivi", "2023", "7kg", "Tivi sony nhap khau", 40, 26000000, 27999999));
        listSp.add(new SanPham("SP5", "Bep", "2023", "2kg", "Bep hang viet nam", 50, 2300000, 3000000));
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
        } else if(value == 0){
            listGioHang.remove(index);
        }else {
            GioHang gh = listGioHang.get(index);
            for (SanPham sp : listSp) {
                if(sp.getIdSP().equals(gh.getMaSp())){
                    sp.setSoLuong(sp.getSoLuong() + gh.getSoLuong() - value);
                }
            }
            gh.setSoLuong(value);
            gh.setThanhTien(gh.getThanhTien() * value); 
        }
        return listGioHang;
    }
}
