package com.java.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.SanPham;

public interface ProductDAO extends JpaRepository<SanPham, String>{

}
