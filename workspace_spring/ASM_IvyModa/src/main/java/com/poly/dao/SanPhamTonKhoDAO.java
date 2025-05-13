package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.LoaiMau;
import com.poly.entity.SanPhamTonKho;
import com.poly.entity.SanPhamTonKhoPK;

public interface SanPhamTonKhoDAO extends JpaRepository<SanPhamTonKho,SanPhamTonKhoPK >{

	@Query("SELECT DISTINCT sp.loaiMau FROM SanPhamTonKho sp WHERE sp.id.maSanPham = :maSanPham")
	List<LoaiMau> maMauTrongSanPhamTonKho(@Param("maSanPham") String maSanPham);


	@Query("SELECT DISTINCT sp.id.sizeSanPham FROM SanPhamTonKho sp WHERE sp.id.maSanPham = ?1")
	List<String> sizeTrongSanPhamTonKho(String maSanPham);
	




	
}
