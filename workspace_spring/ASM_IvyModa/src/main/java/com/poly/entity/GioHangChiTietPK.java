package com.poly.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class GioHangChiTietPK implements Serializable {
	
    @Column(name = "MaKH")
    private String maKH;

    @Column(name = "MaSanPham")
    private String maSanPham;
    
    @Column(name = "MaMau")
    private String maMau;
    
    @Column(name = "SizeSanPham")
    private String sizeSanPham;


	public GioHangChiTietPK(String maKH, String maSanPham, String maMau, String sizeSanPham) {
		super();
		this.maKH = maKH;
		this.maSanPham = maSanPham;
		this.maMau = maMau;
		this.sizeSanPham = sizeSanPham;
	}

	public GioHangChiTietPK() {
		super();
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getMaMau() {
		return maMau;
	}

	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}

	public String getSizeSanPham() {
		return sizeSanPham;
	}

	public void setSizeSanPham(String sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GioHangChiTietPK that = (GioHangChiTietPK) o;
        return Objects.equals(maKH, that.maKH) &&
               Objects.equals(maSanPham, that.maSanPham) &&
               Objects.equals(maMau, that.maMau) &&
               Objects.equals(sizeSanPham, that.sizeSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKH, maSanPham, maMau, sizeSanPham);
    }
	
}
