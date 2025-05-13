package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="SanPham")
public class SanPham {
	@Id
	private String maSanPham;
	private String tenSanPham;
	private boolean isDelete;
	private String hinhAnh;
    private Integer giaCa;
    private boolean gioiTinh;
    
	
	@ManyToOne
    @JoinColumn(name = "MaLoai", nullable = false) // Khóa ngoại tham chiếu đến LoaiSanPham
    private LoaiSanPham loaiSanPham;
	


	
	public SanPham(String maSanPham, String tenSanPham, boolean isDelete, String hinhAnh, Integer giaCa,
			boolean gioiTinh, LoaiSanPham loaiSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.isDelete = isDelete;
		this.hinhAnh = hinhAnh;
		this.giaCa = giaCa;
		this.gioiTinh = gioiTinh;
		this.loaiSanPham = loaiSanPham;
	}
	public SanPham() {
		super();
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public Integer getGiaCa() {
		return giaCa;
	}
	public void setGiaCa(Integer giaCa) {
		this.giaCa = giaCa;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
	    return "SanPham{" +
	            "maSanPham='" + maSanPham + '\'' +
	            ", tenSanPham='" + tenSanPham + '\'' +
	            ", maLoai='" + loaiSanPham.getTenLoai() + '\'' +
	            ", isDelete=" + isDelete +
	            ", hinhAnh='" + hinhAnh + '\'' +
	            '}';
	}

	
}
