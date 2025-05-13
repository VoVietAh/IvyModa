package com.poly.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.KhachHangDAO;
import com.poly.entity.KhachHang;
import com.poly.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{
@Autowired
KhachHangDAO dao;

	@Override
	public List<KhachHang> findAll() {
		return dao.findAll();
	}

	@Override
	public KhachHang findById(String Id) {
		return dao.getReferenceById(Id);
	}

}
