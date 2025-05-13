package com.poly.service;



import java.util.List;

import com.poly.entity.GioHangChiTiet;
import com.poly.entity.GioHangChiTietPK;


public interface GioHangChiTietService {
	
 List<GioHangChiTiet>findAll();
 
 GioHangChiTiet findByID(GioHangChiTietPK id);
 
 List<GioHangChiTiet> findByMaKH(String MaKH);
 
 int tinhTongThanhTien(String maKH);
 
 void create(GioHangChiTiet gioHangChiTiet);
 
 void update(GioHangChiTiet gioHangChiTiet);
 
 void delete(GioHangChiTietPK id);


 
	
}
