package com.poly.serviceIMPL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.GioHangDAO;
import com.poly.entity.GioHang;
import com.poly.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService{
@Autowired
GioHangDAO dao;

@Override
public GioHang findById(String maKH) {
    return dao.findById(maKH).orElse(null);
}

@Override
public void create(GioHang gioHang) {
	dao.save(gioHang);
}

@Override
public void update(GioHang gioHang) {
	dao.save(gioHang);
}





}
