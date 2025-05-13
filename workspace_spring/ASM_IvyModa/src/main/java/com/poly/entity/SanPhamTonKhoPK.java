package com.poly.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SanPhamTonKhoPK implements Serializable {
	@Column(name = "MaSanPham")
    private String maSanPham;
	
	@Column(name = "MaMau")
    private String maMau;
	
	@Column(name = "SizeSanPham")
    private String sizeSanPham;

    public SanPhamTonKhoPK() {}

    public SanPhamTonKhoPK(String maSanPham, String maMau, String sizeSanPham) {
        this.maSanPham = maSanPham;
        this.maMau = maMau;
        this.sizeSanPham = sizeSanPham;
    }

    // Getters and Setters
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

    // Override equals & hashCode để so sánh đúng
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPhamTonKhoPK that = (SanPhamTonKhoPK) o;
        return Objects.equals(maSanPham, that.maSanPham) &&
               Objects.equals(maMau, that.maMau) &&
               Objects.equals(sizeSanPham, that.sizeSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSanPham, maMau, sizeSanPham);
    }
}
