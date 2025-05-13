package com.poly.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.LoaiMauDAO;
import com.poly.entity.LoaiMau;
import com.poly.service.LoaiMauService;

@Service
public class LoaiMauServiceImpl implements LoaiMauService{
@Autowired
LoaiMauDAO dao;

	@Override
	public List<LoaiMau> findAll() {
		return dao.findAll();
	}

	@Override
	public LoaiMau findById(String Id) {
		return dao.getReferenceById(Id);
	}

}
