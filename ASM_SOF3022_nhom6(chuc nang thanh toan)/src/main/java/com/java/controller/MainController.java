package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.DAO.CartDAO;
import com.java.DAO.CartDetailDAO;
import com.java.DAO.ProductDAO;
import com.java.entity.ChiTietGioHang;
import com.java.entity.GioHang;

@Controller
@RequestMapping("home")
public class MainController {
	@Autowired
	CartDetailDAO cartDetaildao;
	@Autowired
	CartDAO cartDao;
	@RequestMapping("delivery")
	public String delivery(@RequestParam("maKH") String maKH,Model model) {
		List<ChiTietGioHang> cart = cartDetaildao.findByGioHang_MaKH(maKH);
		GioHang giohang = cartDao.findById(maKH).orElse(null);
		model.addAttribute("giohang",giohang);
		model.addAttribute("cart",cart);
		return "delivery";
	}
	@RequestMapping("payment")
	public String payment(Model model) {
		
		return "payment";
	}
}
