package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="GioHang")
public class GioHang {
	@Id
	private String maKH;
	private Integer tongThanhTien;
	
	@OneToOne
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;
	


	
	public GioHang(String maKH, Integer tongThanhTien, KhachHang khachHang) {
		super();
		this.maKH = maKH;
		this.tongThanhTien = tongThanhTien;
		this.khachHang = khachHang;
	}
	public GioHang() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public Integer getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(Integer tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	
}
