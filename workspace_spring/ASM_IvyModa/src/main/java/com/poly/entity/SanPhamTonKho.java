package com.poly.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SanPhamTonKho")
public class SanPhamTonKho {
    
    @EmbeddedId
    private SanPhamTonKhoPK id;

    @ManyToOne
    @MapsId("maSanPham") // Trỏ đến maSanPham trong SanPhamTonKhoPK
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham")
    private SanPham sanPham;

    @ManyToOne
    @MapsId("maMau") 
    @JoinColumn(name = "MaMau", referencedColumnName = "MaMau")
    private LoaiMau loaiMau;

    private Integer soLuong;

    public SanPhamTonKho() {}



	public SanPhamTonKho(SanPhamTonKhoPK id, SanPham sanPham, LoaiMau loaiMau, Integer soLuong) {
		super();
		this.id = id;
		this.sanPham = sanPham;
		this.loaiMau = loaiMau;
		this.soLuong = soLuong;
	}



	// Getters and Setters
    public SanPhamTonKhoPK getId() {
        return id;
    }

    public void setId(SanPhamTonKhoPK id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public LoaiMau getLoaiMau() {
        return loaiMau;
    }

    public void setLoaiMau(LoaiMau loaiMau) {
        this.loaiMau = loaiMau;
    }
    @Override
	public String toString() {
	    return "SanPham{" +
	            "maSanPham='" + id.getMaSanPham() + '\'' +
	            ", tenSanPham='" + sanPham.getTenSanPham() + '\'' +
	            ", maLoai='" + sanPham.getLoaiSanPham().getTenLoai() + '\'' +
	            ", hinhAnh='" + sanPham.getHinhAnh() + '\'' +
	            '}';
	}
}
