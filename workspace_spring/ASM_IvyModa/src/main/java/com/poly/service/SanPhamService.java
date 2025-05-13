package com.poly.service;

import java.util.List;


import com.poly.entity.SanPham;

public interface SanPhamService {
List<SanPham>findAll();

List<SanPham>findAllByGender(Boolean gioiTinh);

SanPham findById(String MaSanPham);

String newSanPhamID();

void create(SanPham sanPham);

void upadte(SanPham sanPham);

void deleteByMaSanPham(String maSanPham);

	
}
