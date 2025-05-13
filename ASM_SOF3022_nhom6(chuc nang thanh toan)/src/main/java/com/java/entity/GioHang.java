package com.java.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name="GioHang")
public class GioHang implements Serializable {
	@Id
	@Column(name="MaKH")
	String MaKH;
	@Column(name="TongThanhTien")
	int TongThanhTien;
	@OneToMany(mappedBy = "gioHang")
	List<ChiTietGioHang> chiTietGioHang;
	
}
