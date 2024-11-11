package com.example.dataconnect.models;

import java.util.Date;

public class Kho {
    private int id;
    private String maKho;
    private String ten;
    private String diaDiem;

    private Date ngaySua;
    private Date ngayTao;

    public Kho() {
    }

    public Kho(String maKho, String ten, String diaDiem) {
        this.maKho = maKho;
        this.ten = ten;
        this.diaDiem = diaDiem;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
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
        return "Kho [id=" + id + ", makho=" + maKho + ", ten=" + ten + ", diadiem=" + diaDiem + ", ngaytao=" + ngayTao
                + ", ngaySua=" + ngaySua + "]";
    }
}
