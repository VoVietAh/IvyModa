package com.java.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.entity.ChiTietGioHang;
import com.java.entity.ChiTietGioHangID;
@Repository
public interface CartDetailDAO extends JpaRepository<ChiTietGioHang, ChiTietGioHangID>{
//	@Query("SELECT o FROM ChiTietGioHang o WHERE o.gioHang.MaKH = ?1")
//	List<ChiTietGioHang> findByGioHang_MaKH(String maKh);
	@Query("SELECT c FROM ChiTietGioHang c WHERE c.gioHang.MaKH = :maKH")
	List<ChiTietGioHang> findByGioHang_MaKH(@Param("maKH") String maKH);
}
