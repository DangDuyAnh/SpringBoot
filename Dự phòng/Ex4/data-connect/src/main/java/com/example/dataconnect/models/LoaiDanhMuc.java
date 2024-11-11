package com.example.dataconnect.models;

import java.util.Date;

public class LoaiDanhMuc {
    private int id;
    private String maLoaiDanhMuc;
    private String ten;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;

    public LoaiDanhMuc(){

    }
    public LoaiDanhMuc(String maLoaiDanhMuc, String ten, String moTa) {
        this.maLoaiDanhMuc = maLoaiDanhMuc;
        this.ten = ten;
        this.moTa = moTa;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLoaiDanhMuc() {
        return maLoaiDanhMuc;
    }

    public void setMaLoaiDanhMuc(String maLoaiDanhMuc) {
        this.maLoaiDanhMuc = maLoaiDanhMuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    @Override
    public String toString() {
        return "Loai danh muc [id=" + id + ", maLoaiDanhMuc=" + maLoaiDanhMuc + ", ten=" + ten +
                ", moTa=" + moTa + ", ngaytao=" + ngayTao + ", ngaySua=" + ngaySua + "]";
    }
}
