package com.poly.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.LoaiSanPhamDAO;
import com.poly.entity.LoaiSanPham;
import com.poly.service.LoaiSanPhamService;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{
@Autowired
LoaiSanPhamDAO dao;

@Override
public List<LoaiSanPham> findAll() {
	return dao.findAll();
}

@Override
public LoaiSanPham findById(String MaLoai) {
	return dao.findById(MaLoai).orElse(null);
}


}
