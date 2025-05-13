package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.SanPham;

public interface SanPhamDAO extends JpaRepository<SanPham, String>{
	
	@Query("SELECT sp.maSanPham FROM SanPham sp ORDER BY sp.maSanPham DESC LIMIT 1")
	String findMaxProductCode();
	
	@Query("UPDATE SanPham sp SET sp.isDelete = true WHERE sp.maSanPham = :maSanPham")
	void deleteByMaSanPham(@Param("maSanPham") String maSanPham);
	 
	@Query("SELECT sp FROM SanPham sp WHERE sp.gioiTinh = ?1 AND sp.isDelete = false ")
	List<SanPham> findAllByGender( Boolean gioiTinh);
	
	@Query("SELECT sp FROM SanPham sp WHERE sp.isDelete = false ")
	List<SanPham> findAll();


}
