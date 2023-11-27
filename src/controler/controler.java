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
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class controler {

    private final List<SanPham> listSp = new ArrayList<>();
    public List<GioHang> listGioHang = new ArrayList<>();
    public List<HoaDon> listHoaDonChuaThanhToan = new ArrayList<>();
    public List<HoaDon> listHDDaThanhToan = new ArrayList<>();
    public List<HoaDon> listHDHuy = new ArrayList<>();

    public Double total = 0d;

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
                listSp.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), "2023", "12kg", "abc", rs.getInt(4), 0, rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSp;
    }

    public List<GioHang> getProduct(int value, int index) {
        SanPham sp = listSp.get(index);
        GioHang newSp = new GioHang(sp.getId(), sp.getIdSP(), sp.getTenSp(), sp.getGiaBan(), value * sp.getGiaBan(), value);
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
                                total = gioHang.getThanhTien();
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            listGioHang.add(newSp);
                            total += newSp.getThanhTien();
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
        } else {
            GioHang gh = listGioHang.get(index);
            for (SanPham sp : listSp) {
                if (sp.getIdSP().equals(gh.getMaSp())) {
                    if (value == 0) {
                        sp.setSoLuong(sp.getSoLuong() + listGioHang.get(index).getSoLuong());
                        total -= sp.getGiaBan() * listGioHang.get(index).getSoLuong();
                        listGioHang.remove(index);
                    } else {
                        sp.setSoLuong(sp.getSoLuong() + gh.getSoLuong() - value);
                        total -= sp.getGiaBan() * (gh.getSoLuong() - value);
                        gh.setSoLuong(value);
                        gh.setThanhTien(gh.getSoLuong() * gh.getDonGia());
                    }
                }
            }
        }
        return listGioHang;
    }

    public void createBill() {
        Random r = new Random();
        String ranHd = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 2; i++) {
            int index = r.nextInt(alphabet.length());
            ranHd += String.valueOf(alphabet.charAt(index));
        }
        for (int i = 0; i < 5; i++) {
            ranHd += String.valueOf(r.nextInt(10));
        }
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int i = 0;
        try {
            i++;
            try (PreparedStatement ps = openConnection().prepareStatement("exec SP_AddHd ?,?,?,?,?,?")) {
                ps.setString(1, ranHd);
                ps.setString(2, sdf.format(now));
                ps.setString(3, "Kien");
                ps.setInt(4, i);
                ps.setDouble(5, 0);
                ps.setInt(6, i);
                ps.executeUpdate();
            }
            openConnection().close();
        } catch (Exception e) {
        }
        getDataBill();
    }

    public List<HoaDon> getDataBill() {
        listHoaDonChuaThanhToan.clear();
        try {
            Statement sta = openConnection().createStatement();
            ResultSet rs = sta.executeQuery("select * from HoaDon ");//where trang_thai like '%Chua%'
            while (rs.next()) {
                if (rs.getString("trang_thai").equals("Da Thanh Toan")) {
                    listHDDaThanhToan.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getDouble(6)));
                } else {
                    listHoaDonChuaThanhToan.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), 0));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(controler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHoaDonChuaThanhToan;
    }

    public List<GioHang> detailedInvoice(int id) {
        listGioHang.clear();
        try (Connection con = openConnection()) {
            PreparedStatement ps = con.prepareStatement("select sp.id,sp.ma_san_pham,sp.ten_san_pham,hdct.so_luong,hdct.don_gia from HoaDonChiTiet hdct join SanPham sp on sp.id = hdct.id_san_pham where hdct.id_hoa_don = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listGioHang.add(new GioHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(5), rs.getDouble(5) * rs.getInt(4), rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

    public List<HoaDon> btnPay(HoaDon hd) {
        try (Connection conn = openConnection()) {
            PreparedStatement ps = conn.prepareStatement("exec SP_BtnPay ?,?");
            ps.setString(1, hd.getMaHD());
            ps.setDouble(2, hd.getTongTien());
            ps.executeUpdate();

            for (GioHang gh : listGioHang) {
                ps = conn.prepareStatement("exec SP_AddHdct ?,?,?,?");
                ps.setInt(1, hd.getId());
                ps.setInt(2, gh.getId());
                ps.setDouble(3, gh.getSoLuong());
                ps.setDouble(4, gh.getDonGia());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        hd.setTinhTrang("Da Thanh Toan");
        listHDDaThanhToan.add(hd);
        listHoaDonChuaThanhToan.remove(hd);
        listGioHang.clear();
        return listHDDaThanhToan;

    }

    public List<HoaDon> cancelBill(HoaDon hd) {
        hd.setTinhTrang("Huy");
        listHDHuy.add(hd);
        listHoaDonChuaThanhToan.remove(hd);
        listGioHang.clear();
        return listHDHuy;
    }

}
