package com.java.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "ChiTietGioHang")
public class ChiTietGioHang{
	@EmbeddedId
	ChiTietGioHangID id;
	
	@ManyToOne
	@MapsId("maKH")
	@JoinColumn(name="MaKH", referencedColumnName = "MaKH")
	GioHang gioHang;
	
	@ManyToOne
	@MapsId("MaSanPham")
	@JoinColumn(name="MaSanPham", referencedColumnName = "MaSanPham")
	SanPham sanPham;
	
	@Column(name="SoLuong")
	int SoLuong;
	
	
}
