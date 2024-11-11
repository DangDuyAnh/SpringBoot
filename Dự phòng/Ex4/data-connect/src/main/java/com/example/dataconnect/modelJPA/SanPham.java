package com.example.dataconnect.modelJPA;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sanpham")
public class SanPham{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "masanpham")
    private String maSanPham;

    @Column(name = "danhmuc")
    private int danhMuc;
    private int kho;
    private String ten;

    @Column(name = "motasanpham")
    private String moTaSanPham;

    @Column(name = "duongdananh")
    private String duongDanAnh;

    @Column(name = "soluongsanpham")
    private int soLuongSanPham;

    @Column(name = "soluongban")
    private int soLuongBan;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaysua")
    private Date ngaySua;

    @Override
    public String toString() {
        return "San pham [id=" + id + ", maSanPham=" + maSanPham + ", danhMuc=" + danhMuc +
                ", kho=" + kho + ", ten=" + ten + ", moTaSanPham= " + moTaSanPham
                + ", soLuongSanPham=" + soLuongSanPham + ", soLuongBan= " + soLuongBan
                + ", ngayTao=" + ngayTao + ", ngaySua= " + ngaySua + "]";
    }

    public SanPham() {
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(int danhMuc) {
        this.danhMuc = danhMuc;
    }

    public int getKho() {
        return kho;
    }

    public void setKho(int kho) {
        this.kho = kho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getDuongDanAnh() {
        return duongDanAnh;
    }

    public void setDuongDanAnh(String duongDanAnh) {
        this.duongDanAnh = duongDanAnh;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
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
}
