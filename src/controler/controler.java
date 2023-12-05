/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GioHang;
import model.SanPham;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import java.util.Date;
import model.Voucher;

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
    public List<HoaDon> listAll = new ArrayList<>();
    public List<HoaDon> listSearch = new ArrayList<>();
    public List<Voucher> listVoucher = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Double total = 0d;

    private Connection openConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost;databaseName=ASM_SOF203;user=sa;password=1234";
        return DriverManager.getConnection(url);
    }

    public List<SanPham> getDataProducts() {
        listSp.clear();
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

    public List<GioHang> updateProduct(int value, int index) {
        if (value <= 0) {
            JOptionPane.showMessageDialog(null, "So luong mua can khong hop le");
        } else {
            GioHang gh = listGioHang.get(index);
            for (SanPham sp : listSp) {
                if (sp.getIdSP().equals(gh.getMaSp())) {
                    if (value > listGioHang.get(index).getSoLuong()) {
                        sp.setSoLuong(sp.getSoLuong() - (value - gh.getSoLuong()));
                        total = sp.getGiaBan() * value;
                        gh.setSoLuong(value);
                        gh.setThanhTien(gh.getSoLuong() * gh.getDonGia());
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

    public List<GioHang> removeProduct(int index) {
        GioHang gh = listGioHang.get(index);
        for (SanPham sp : listSp) {
            if (sp.getIdSP().equals(gh.getMaSp())) {
                sp.setSoLuong(sp.getSoLuong() + listGioHang.get(index).getSoLuong());
                total -= sp.getGiaBan() * listGioHang.get(index).getSoLuong();
                listGioHang.remove(index);
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
        } catch (SQLException e) {
        }
        getDataBill();
    }

    public List<HoaDon> getDataBill() {
        listHoaDonChuaThanhToan.clear();
        listHDHuy.clear();
        listHDDaThanhToan.clear();
        listAll.clear();
        try {
            Statement sta = openConnection().createStatement();
            ResultSet rs = sta.executeQuery("select * from HoaDon ");
            while (rs.next()) {
                if (rs.getString("trang_thai").equalsIgnoreCase("Da Thanh Toan")) {
                    listHDDaThanhToan.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getDouble(6)));
                    listAll.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getDouble(6)));
                } else if (rs.getString("trang_thai").equalsIgnoreCase("Chua Thanh Toan")) {
                    listHoaDonChuaThanhToan.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), 0));
                } else {
                    listAll.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getDouble(6)));
                    listHDHuy.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), 0));
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
        }
        return listGioHang;
    }

    public List<HoaDon> btnPay(HoaDon hd, int keyVoucher, int idVoucher) {
        try (Connection conn = openConnection()) {
            PreparedStatement ps = conn.prepareStatement("exec SP_BtnPay ?,?,?");
            ps.setString(1, hd.getMaHD());
            ps.setDouble(2, hd.getTongTien());
            if (keyVoucher == 1) {
                ps.setInt(3, idVoucher);
            } else {
                ps.setString(3, null);
            }
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
        }
        getDataProducts();
        hd.setTinhTrang("Da Thanh Toan");
        listHDDaThanhToan.add(hd);
        listHoaDonChuaThanhToan.remove(hd);
        listGioHang.clear();
        return listHDDaThanhToan;

    }

    public List<HoaDon> cancelBill(HoaDon hd) {
        try (Connection conn = openConnection()) {
            PreparedStatement ps = null;
            for (GioHang gioHang : listGioHang) {
                ps = conn.prepareStatement("update SanPham set so_luong_ton = (so_luong_ton + ?) where ma_san_pham = ?");
                ps.setInt(1, gioHang.getSoLuong());
                ps.setString(2, gioHang.getMaSp());
                ps.executeUpdate();
            }
            ps = conn.prepareStatement("update HoaDon set trang_thai = 'Huy' where id = ?");
            ps.setInt(1, hd.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        getDataProducts();
        getDataBill();
        listGioHang.clear();
        return listHDHuy;
    }

    public void saveData() {
        try (Connection conn = openConnection()) {
            for (SanPham sp : listSp) {
                PreparedStatement ps = conn.prepareStatement("update SanPham set so_luong_ton = ? where ma_san_pham = ?");
                ps.setInt(1, sp.getSoLuong());
                ps.setString(2, sp.getIdSP());
                ps.executeUpdate();
            }
        } catch (Exception e) {
        }

    }

    public List<HoaDon> search(Date f, Date l, String search, int key) throws ParseException {
        listSearch.clear();

        for (HoaDon hd : listAll) {
            // tìm theo ngày           
            if (sdf.parse(hd.getNgayTao()).before(l) && sdf.parse(hd.getNgayTao()).after(f)) {
                if (search.isBlank()) {
                    listSearch.add(hd);
                } else {
                    CbxIndex(key, hd, search);
                }
            }
        }
        return listSearch;
    }

    public List<HoaDon> CbxIndex(int key, HoaDon hd, String search) {

        switch (key) {
            case 0 -> {
                if (hd.getMaHD().contains(search)) {
                    listSearch.add(hd);
                }
            }
            case 1 -> {
                if (hd.getTenNV().contains(search)) {
                    listSearch.add(hd);
                }
            }
//                        case 2 -> {
//                            if (hd.getId().contains(search)) {
//                                listSearch.add(hd);
//                            }
//                        }
            case 3 -> {
                if (hd.getTinhTrang().contains(search)) {
                    listSearch.add(hd);
                }
            }
            default -> {
            }
        }
        return listSearch;
    }

    public void createVoucher(String id, String tieuDe, Double giaTri,String dieuKien, String loai, Date s, Date e) {
        try (Connection conn = openConnection(); PreparedStatement ps = conn.prepareStatement("SP_AddVoucher ?,?,?,?,?,?,?")) {
            ps.setString(1, id);
            ps.setString(2, tieuDe);
            ps.setDouble(3, giaTri);
            ps.setString(4, dieuKien);
            ps.setString(5, loai);
            ps.setString(6, sdf.format(s));
            ps.setString(7, sdf.format(e));
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        getDataVoucher();
    }

    public List<Voucher> getDataVoucher() {
        listVoucher.clear();
        try (Connection conn = openConnection(); Statement sta = conn.createStatement()) {
            ResultSet rs = sta.executeQuery("Select * from Voucher");
            while(rs.next()){
               listVoucher.add(new Voucher(rs.getInt("id"),rs.getString("ma_voucher"), rs.getString("tieu_de"), rs.getString("loai_giam_gia"), rs.getString("dieu_kien"),rs.getString("ngay_bat_dau"), rs.getString("ngay_ket_thuc"), rs.getDouble("gia_tri")));
            }
        } catch (Exception ex) {
        }
        return listVoucher;
    }
}
