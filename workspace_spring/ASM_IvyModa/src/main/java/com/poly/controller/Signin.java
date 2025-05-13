package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.KhachHang;
import com.poly.service.KhachHangService;
import com.poly.service.SessionService;



@Controller
public class Signin {
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	SessionService sessionService;
	
	List<KhachHang> users ;

	
	@RequestMapping("/user/form")
	public String form(Model model) {
		return "home/sigin_login";
	}
	
	@RequestMapping("/user/sigup")
	public String sigup(
			@RequestParam("signupUsername") String username,
			@RequestParam("signupPassword") String password,
			@RequestParam("signupEmail") String email,
			@RequestParam("signupPhone") String phone,
			Model model) {
			
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phone);
//		KhachHang user = new KhachHang(makh, tenkh, email, sdt, password, diachi, ngaysinh);
//		khachHangService.create(user);
		
		return "redirect:/user/form";
	}
	
	@GetMapping("/home/login")
	public String showLoginPage() {
	    return "home/sigin_login"; // 
	}

	
	@PostMapping("/home/login")
	public String login(
	        @RequestParam("sdtlLogIn") String sdt,
	        @RequestParam("passwordLogIn") String pass,
	        Model model) {

	    users = khachHangService.findAll();
	    System.out.println(users);
	    

	    for (KhachHang user : users) {
	        if (sdt.equals(user.getSdt()) && pass.equals(user.getPass())) {
	            model.addAttribute("message", "Đăng nhập thành công");
	            sessionService.set("user", user);

	            return "redirect:/home/cartegory"; // Nếu không có trang trước đó, về trang chính
	        }
	    }

	    model.addAttribute("message", "Đăng nhập không thành công");
	    return "redirect:/home/form";
	}


	
	@RequestMapping("/user/logout")
	public String requestMethodName() {
		sessionService.remove("user");
		
		return "redirect:/user/form";
	}
	
	
	

}
