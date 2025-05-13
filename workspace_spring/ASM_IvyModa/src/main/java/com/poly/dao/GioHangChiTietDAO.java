package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.GioHangChiTiet;
import com.poly.entity.GioHangChiTietPK;

public interface GioHangChiTietDAO extends JpaRepository<GioHangChiTiet, GioHangChiTietPK>{
	
	
	@Query("SELECT g FROM GioHangChiTiet g WHERE g.gioHang.maKH = :maKH")
	List<GioHangChiTiet> findByGioHang_MaKH(@Param("maKH") String maKH);
}
