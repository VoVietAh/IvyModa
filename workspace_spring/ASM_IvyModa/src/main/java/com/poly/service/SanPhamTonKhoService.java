package com.poly.service;

import java.util.List;


import com.poly.entity.LoaiMau;
import com.poly.entity.SanPhamTonKho;
import com.poly.entity.SanPhamTonKhoPK;

public interface SanPhamTonKhoService  {
	
List<SanPhamTonKho>findAll();


SanPhamTonKho findById(SanPhamTonKhoPK Id);

List<LoaiMau> loaiMauTrongSanPhamTonKho(String MaSanPham);

List<String> sizeTrongSanPhamTonKho(String MaSanPham);

void create (SanPhamTonKho sanPhamTonKho);

void update (SanPhamTonKho sanPhamTonKho);

void delete (SanPhamTonKho sanPhamTonKho);

	
}
