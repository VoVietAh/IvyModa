package com.poly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.entity.LoaiMau;

public interface LoaiMauService {
 List<LoaiMau>findAll();

 LoaiMau findById(String MaMau);
	
}
