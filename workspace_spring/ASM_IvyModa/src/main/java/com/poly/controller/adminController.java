package com.poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.LoaiMau;
import com.poly.entity.LoaiSanPham;
import com.poly.entity.SanPham;
import com.poly.entity.SanPhamTonKho;
import com.poly.entity.SanPhamTonKhoPK;
import com.poly.service.LoaiMauService;
import com.poly.service.LoaiSanPhamService;
import com.poly.service.SanPhamService;
import com.poly.service.SanPhamTonKhoService;

import jakarta.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig()
public class adminController {
	
	private static final String UPLOAD_DIR = "src/main/resources/static/img/";

	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	SanPhamTonKhoService sanPhamTonKhoService;
	
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	LoaiMauService loaiMauService;
	
	
	List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
	
    @RequestMapping("/home/admin/index")
    public String about(Model model) {
    	
        loaiSanPhamList = loaiSanPhamService.findAll();
    	model.addAttribute("loaiSanPhamList",loaiSanPhamList);
        return "home/admin";
    }
    
    @RequestMapping("/home/admin/create")
    public String createProduct(Model model,
    		@RequestParam("tenSanPham") String tenSanPham,
    		@RequestParam("loaiSanPham") String maLoai,
    		@RequestParam("giaSanPham") Integer giaSanPham,
    		@RequestParam("gioiTinhSanPham") Boolean gioiTinhSanPham,
    		@RequestParam("hinhAnh") MultipartFile file,
    		@RequestParam("size") List<String> sizes,
    		@RequestParam("soLuongSanPham") Integer soLuong,
    		@RequestParam("mauSac") List<String> listMaMau
    		) throws IOException {
    	
    	// lưu ảnh vào thư mục 
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    	
        LoaiSanPham loaiSanPham = loaiSanPhamService.findById(maLoai);
        
        String maSanPham = sanPhamService.newSanPhamID();
        
    	SanPham sanPham = new SanPham();
    	sanPham.setMaSanPham(maSanPham);
    	sanPham.setLoaiSanPham(loaiSanPham);
    	sanPham.setGiaCa(giaSanPham);
    	sanPham.setTenSanPham(tenSanPham);
    	sanPham.setDelete(false);
    	sanPham.setHinhAnh(fileName);
    	sanPham.setGioiTinh(gioiTinhSanPham);
    	
    	sanPhamService.create(sanPham);

    	
        for (String size : sizes) {
        	for(String maMau : listMaMau) {
        		LoaiMau loaimau = loaiMauService.findById(maMau);
        		
                SanPhamTonKho sanPhamTonKho = new SanPhamTonKho();
                SanPhamTonKhoPK id = new SanPhamTonKhoPK(maSanPham, maMau, size);
                sanPhamTonKho.setId(id);
                sanPhamTonKho.setLoaiMau(loaimau);
                sanPhamTonKho.setSanPham(sanPham);
                sanPhamTonKho.setSoLuong(soLuong);     

                sanPhamTonKhoService.create(sanPhamTonKho);
        	}
        }
    	
    	
    	
        return "redirect:/home/admin/index"; 
    }

}
