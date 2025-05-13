package com.poly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.entity.KhachHang;


public interface KhachHangService {
	
List<KhachHang>findAll();

 KhachHang findById(String maKH);
	
}
