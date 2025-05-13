package com.poly.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.SanPhamTonKhoDAO;
import com.poly.entity.LoaiMau;
import com.poly.entity.SanPhamTonKho;
import com.poly.entity.SanPhamTonKhoPK;
import com.poly.service.SanPhamTonKhoService;

@Service
public class SanPhamTonKhoServiceImpl implements SanPhamTonKhoService{
@Autowired
SanPhamTonKhoDAO dao;

	@Override
	public List<SanPhamTonKho> findAll() {
		return dao.findAll();
	}

	@Override
	public SanPhamTonKho findById(SanPhamTonKhoPK Id) {
	    return dao.findById(Id).orElse(null); // Trả về null nếu không tìm thấy
	}

	@Override
	public List<LoaiMau> loaiMauTrongSanPhamTonKho(String MaSanPham) {
		return dao.maMauTrongSanPhamTonKho(MaSanPham);
	}

	@Override
	public List<String> sizeTrongSanPhamTonKho(String MaSanPham) {
		return dao.sizeTrongSanPhamTonKho(MaSanPham);
	}

	@Override
	public void create(SanPhamTonKho sanPhamTonKho) {
		dao.save(sanPhamTonKho);
	}

	@Override
	public void update(SanPhamTonKho sanPhamTonKho) {
		dao.save(sanPhamTonKho);		
	}

	@Override
	public void delete(SanPhamTonKho sanPhamTonKho) {
		dao.delete(sanPhamTonKho);
	}




}
