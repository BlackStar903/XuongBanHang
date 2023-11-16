/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoantp
 */
public class HoaDon {

    private int index;
    private String maHD, ngayTao, tenNV, tinhTrang;
    private double tongTien;

    public HoaDon() {

    }

    public HoaDon(int index, String maHD, String ngayTao, String tenNV, String tinhTrang, double tongTien) {
        this.index = index;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

}
