package com.poly.service;



import com.poly.entity.GioHang;


public interface GioHangService {

 GioHang findById(String maKH);
 
 void create(GioHang gioHang);
 
 void update(GioHang gioHang);

	
}
