package com.poly.serviceIMPL;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.GioHangChiTietDAO;
import com.poly.entity.GioHangChiTiet;
import com.poly.entity.GioHangChiTietPK;
import com.poly.service.GioHangChiTietService;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService{
@Autowired
GioHangChiTietDAO dao;


@Override
public List<GioHangChiTiet> findAll() {
	return dao.findAll();
}

@Override
public GioHangChiTiet findByID(GioHangChiTietPK id) {
	return dao.findById(id).orElse(null);
}

@Override
public void create(GioHangChiTiet gioHangChiTiet) {
	dao.save(gioHangChiTiet);
}

@Override
public void update(GioHangChiTiet gioHangChiTiet) {
	dao.save(gioHangChiTiet);
}

@Override
public void delete(GioHangChiTietPK id) {
	dao.deleteById(id);
}

@Override
public int tinhTongThanhTien(String maKH) {
    List<GioHangChiTiet> items = dao.findByGioHang_MaKH(maKH);
    return items.stream().mapToInt(item -> item.getSoLuong() * item.getSanPhamTonKho().getSanPham().getGiaCa()).sum();
}

@Override
public List<GioHangChiTiet> findByMaKH(String MaKH) {
	return dao.findByGioHang_MaKH(MaKH);
}





}
