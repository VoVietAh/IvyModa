package com.poly.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="KhachHang")
public class KhachHang {
	@Id
	private String maKH;
	private String tenKH;
	private String email;
	private String sdt;
	private String pass;
	private String diaChi;
	
    @Temporal(TemporalType.DATE) // Chỉ định kiểu dữ liệu Date
	private Date NgaySinh;
    
	public KhachHang(String maKH, String tenKH, String email, String sdt, String pass, String diaChi, Date ngaySinh) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.email = email;
		this.sdt = sdt;
		this.pass = pass;
		this.diaChi = diaChi;
		NgaySinh = ngaySinh;
	}

	public KhachHang() {
		super();
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", email=" + email + ", sdt=" + sdt + ", pass=" + pass
				+ ", diaChi=" + diaChi + ", NgaySinh=" + NgaySinh + "]";
	}


    

	
    
    
    
	
	
}
