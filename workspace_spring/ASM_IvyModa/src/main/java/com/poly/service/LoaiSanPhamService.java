package com.poly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.entity.LoaiSanPham;

public interface LoaiSanPhamService {
List<LoaiSanPham>findAll();

LoaiSanPham findById(String MaLoai);
	
}
