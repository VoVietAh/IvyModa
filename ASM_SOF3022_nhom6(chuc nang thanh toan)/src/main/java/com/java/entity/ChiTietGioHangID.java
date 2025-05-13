package com.java.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable
public class ChiTietGioHangID implements Serializable{
	
	
	@Column(name="MaKH")
	private String maKH;
	@Column(name="MaSanPham")
	private String maSanPham;
	
	public ChiTietGioHangID() {}
	
	public ChiTietGioHangID(String maKH, String maSanPham) {
        this.maKH = maKH;
        this.maSanPham = maSanPham;
    }
	
	 public String getMaKH() { return maKH; }
	    public void setMaKH(String maKH) { this.maKH = maKH; }

	    public String getMaSanPham() { return maSanPham; }
	    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }
	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ChiTietGioHangID that = (ChiTietGioHangID) o;
	        return Objects.equals(maKH, that.maKH) && Objects.equals(maSanPham, that.maSanPham);
	    }
	    @Override
	    public int hashCode() {
	        return Objects.hash(maKH, maSanPham);
	    }
}
