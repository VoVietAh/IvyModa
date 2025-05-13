package com.java.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.GioHang;

public interface CartDAO extends JpaRepository<GioHang, String>{

}
