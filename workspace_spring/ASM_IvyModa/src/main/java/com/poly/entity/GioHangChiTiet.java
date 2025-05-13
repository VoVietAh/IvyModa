package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="ChiTietGioHang")
public class GioHangChiTiet {

	@EmbeddedId
	private GioHangChiTietPK id;
	
	@ManyToOne
    @MapsId("maKH")
    @JoinColumn(name = "MaKH")
    private GioHang gioHang;

	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham", insertable = false, updatable = false),
	    @JoinColumn(name = "MaMau", referencedColumnName = "MaMau", insertable = false, updatable = false),
	    @JoinColumn(name = "SizeSanPham", referencedColumnName = "SizeSanPham", insertable = false, updatable = false)
	})
	private SanPhamTonKho sanPhamTonKho;


    @Column(name = "SoLuong")
    private int soLuong;
    

	public GioHangChiTiet(GioHangChiTietPK id, GioHang gioHang, SanPhamTonKho sanPhamTonKho, int soLuong) {
		super();
		this.id = id;
		this.gioHang = gioHang;
		this.sanPhamTonKho = sanPhamTonKho;
		this.soLuong = soLuong;
	}

	public GioHangChiTiet() {
		super();
	}

	public GioHangChiTietPK getId() {
		return id;
	}

	public void setId(GioHangChiTietPK id) {
		this.id = id;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public SanPhamTonKho getSanPhamTonKho() {
		return sanPhamTonKho;
	}

	public void setSanPhamTonKho(SanPhamTonKho sanPhamTonKho) {
		this.sanPhamTonKho = sanPhamTonKho;
	}

	@Override
	public String toString() {
		return "GioHangChiTiet [id=" + id + ", gioHang=" + gioHang + ", sanPhamTonKho=" + sanPhamTonKho + ", soLuong="
				+ soLuong + "]";
	}


	
	
}
