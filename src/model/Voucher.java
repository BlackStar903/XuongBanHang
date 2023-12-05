/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Voucher {
    private int id;
    private String maVoucher,tieuDe,loai,dieuKien,ngayBatDau,ngayKetThuc;
    private Double giaTri;

    public Voucher() {
    }

    public Voucher(int id, String maVoucher, String tieuDe, String loai, String dieuKien, String ngayBatDau, String ngayKetThuc, Double giaTri) {
        this.id = id;
        this.maVoucher = maVoucher;
        this.tieuDe = tieuDe;
        this.loai = loai;
        this.dieuKien = dieuKien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaTri = giaTri;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(Double giaTri) {
        this.giaTri = giaTri;
    }
    
    
}
