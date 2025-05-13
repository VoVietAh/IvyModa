package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="LoaiMau")
public class LoaiMau {
	@Id
	private String maMau;
	private String tenMau;
	private String hinhAnh;
	
	
	public LoaiMau(String maMau, String tenMau, String hinhAnh) {
		super();
		this.maMau = maMau;
		this.tenMau = tenMau;
		this.hinhAnh = hinhAnh;
	}

	public LoaiMau() {
		super();
	}
	
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMaMau() {
		return maMau;
	}
	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}

	@Override
	public String toString() {
		return "LoaiMau [maMau=" + maMau + ", tenMau=" + tenMau + ", hinhAnh=" + hinhAnh + "]";
	}

	
	
	
	
}
