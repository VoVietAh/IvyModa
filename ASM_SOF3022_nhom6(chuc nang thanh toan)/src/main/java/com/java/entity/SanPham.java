package com.java.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="SanPham")
public class SanPham implements Serializable{
	@Id
	@Column(name="MaSanPham")
	String MaSanPham;
	@Column(name="TenSanPham")
	String TenSanPham;
	@Column(name="giaca")
	int giaca;
	@OneToMany(mappedBy = "sanPham")
	List<ChiTietGioHang> chiTietGioHang;
	
	
}
