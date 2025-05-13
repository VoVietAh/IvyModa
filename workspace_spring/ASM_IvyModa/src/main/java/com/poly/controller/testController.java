package com.poly.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.GioHang;
import com.poly.entity.GioHangChiTiet;
import com.poly.entity.GioHangChiTietPK;
import com.poly.entity.KhachHang;
import com.poly.entity.LoaiMau;
import com.poly.entity.SanPham;
import com.poly.entity.SanPhamTonKho;
import com.poly.entity.SanPhamTonKhoPK;
import com.poly.service.GioHangChiTietService;
import com.poly.service.GioHangService;
import com.poly.service.LoaiMauService;
import com.poly.service.SanPhamService;
import com.poly.service.SanPhamTonKhoService;
import com.poly.service.SessionService;

@Controller
public class testController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	SanPhamTonKhoService sanPhamTonKhoService;
	
	@Autowired
	LoaiMauService loaiMauService;
	
	@Autowired
	GioHangChiTietService gioHangChiTietService;
	
	@Autowired
	GioHangService gioHangService;
	
	@Autowired
	SessionService sessionService;
	
	List<SanPham> sanPhamList = new ArrayList<>();
	List<SanPhamTonKho> sanPhamTonKhoList = new ArrayList<>();
	List<LoaiMau> loaiMauList = new ArrayList<>();
	List<String> sizeList = new ArrayList<>();
	List<GioHangChiTiet> gioHangChiTietList = new ArrayList<>();
	
    
    
    @RequestMapping("/home/index")
    public String about3(Model model) {
        model.addAttribute("content", "home/index");
        return "shared/layout";
    }

    @RequestMapping("/home/cart/view")
    public String viewCart(Model model) {
        model.addAttribute("content", "home/cart");
        KhachHang user = sessionService.get("user");
        String maKH = user.getMaKH();
        GioHang gioHang = gioHangService.findById(maKH);
        List<GioHangChiTiet> gioHangChiTietList = gioHangChiTietService.findByMaKH(maKH);

        int soLuongSanPham = gioHangChiTietList.stream().mapToInt(GioHangChiTiet::getSoLuong).sum();

        model.addAttribute("gioHangChiTietList", gioHangChiTietList);
        model.addAttribute("gioHang", gioHang);
        model.addAttribute("soLuongSanPham", soLuongSanPham);

        return "shared/layout";
    }

    
    @RequestMapping( "/home/cart" )
    public String addToCart(Model model,
            @RequestParam("maSanPham") String maSanPham, 
            @RequestParam("size") String size,
            @RequestParam("soLuong") int soLuong,
            @RequestParam("giaCa") int giaCa,
    		@RequestParam("maMauUrl") String maMauUrl
    		){

        model.addAttribute("content", "home/cart");
        
        KhachHang user = sessionService.get("user");
        String maKH = user.getMaKH();
        
        // Kiểm tra xem khách hàng đã có giỏ hàng chưa
        GioHang gioHang = gioHangService.findById(maKH);
        if (gioHang == null) {
            // Nếu chưa có, tạo mới giỏ hàng
            gioHang = new GioHang();
            gioHang.setMaKH(maKH);
            gioHang.setTongThanhTien(0); // Ban đầu chưa có sản phẩm nên tổng tiền là 0
            gioHangService.create(gioHang);
        }

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        GioHangChiTietPK pk = new GioHangChiTietPK(maKH,maSanPham,maMauUrl,size);
        Optional<GioHangChiTiet> existingItem = Optional.ofNullable(gioHangChiTietService.findByID(pk));

        if (existingItem.isPresent()) {
            // Nếu sản phẩm đã có, cập nhật số lượng
            GioHangChiTiet gioHangChiTiet = existingItem.get();
            int soLuongMoi = gioHangChiTiet.getSoLuong() + soLuong;
            gioHangChiTiet.setSoLuong(soLuongMoi);
            gioHangChiTietService.update(gioHangChiTiet);
        } else {
            // Nếu sản phẩm chưa có, thêm mới vào chi tiết giỏ hàng
        	SanPhamTonKhoPK id = new SanPhamTonKhoPK(maSanPham, maMauUrl, size);
            SanPhamTonKho sanPhamTonKho = sanPhamTonKhoService.findById(id);
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setId(pk);
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setSanPhamTonKho(sanPhamTonKho);
            gioHangChiTiet.setSoLuong(soLuong);
                       
            gioHangChiTietService.create(gioHangChiTiet);
        }
        // tính tổng số lượng sản phầm trong giỏ hàng
        int soLuongSanPham = 0;
        gioHangChiTietList =  gioHangChiTietService.findByMaKH(maKH);
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTietList) {
        	soLuongSanPham = soLuongSanPham +  gioHangChiTiet.getSoLuong();
		}
        
        System.out.println(soLuongSanPham);

        System.out.println(gioHangChiTietList);
        model.addAttribute("gioHangChiTietList",gioHangChiTietList);
        model.addAttribute("gioHang", gioHang);
        model.addAttribute("soLuongSanPham",soLuongSanPham);


        // Cập nhật tổng thành tiền của giỏ hàng
        int tongThanhTien = gioHangChiTietService.tinhTongThanhTien(maKH);
        gioHang.setTongThanhTien(tongThanhTien);
        gioHangService.update(gioHang);

//        return "shared/layout";
        return "redirect:/home/cart/view";
    }


    @RequestMapping({"/home/product/{maSanPham}-{maMau}",
    		"/home/product"
    })
    public String about5(Model model,
    		@PathVariable("maSanPham") String maSanPham,
    		@PathVariable("maMau") String maMau
    		){
        model.addAttribute("content", "home/product");
        
        SanPham sanPham = sanPhamService.findById(maSanPham);
        LoaiMau loaiMau = loaiMauService.findById(maMau);
        
        loaiMauList = sanPhamTonKhoService.loaiMauTrongSanPhamTonKho(maSanPham);
        sizeList = sanPhamTonKhoService.sizeTrongSanPhamTonKho(maSanPham);
        System.out.println(sizeList);
        
        model.addAttribute("maMauUrl",maMau);
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("loaiMau",loaiMau);
        model.addAttribute("sizeList",sizeList);
        model.addAttribute("loaiMauList",loaiMauList);

        

        return "shared/layout";
    }

    
    @RequestMapping({"/home/cartegory", "/home/cartegory/{gioiTinh}"})
    public String about6(Model model, @PathVariable(required = false) String gioiTinh) {
        sanPhamTonKhoList = sanPhamTonKhoService.findAll();

        if (gioiTinh != null) { 
            boolean genderValue = Boolean.parseBoolean(gioiTinh);
            sanPhamList = sanPhamService.findAllByGender(genderValue);
        } else {
            sanPhamList = sanPhamService.findAll();
        }

        model.addAttribute("content", "home/cartegory");
        model.addAttribute("sanPhamTonKhoList", sanPhamTonKhoList);
        model.addAttribute("sanPhamList", sanPhamList);

        return "shared/layout";
    }




    
    @RequestMapping("/home/payment")
    public String about7(Model model) {
        model.addAttribute("content", "home/payment");
        return "shared/layout"; 
    }
    
    @RequestMapping("/home/delivery")
    public String about8(Model model) {
        model.addAttribute("content", "home/delivery");
        return "shared/layout"; 
    }
    
    @RequestMapping("/home/login")
    public String about9(Model model) {
        return "home/sigin_login"; 
    }
    
    @PostMapping("/home/cart/delete")
    public String deleteCartItem(@RequestParam("maSanPham") String maSanPham,
                                 @RequestParam("maKH") String maKH,
                                 @RequestParam("size") String size,
                                 @RequestParam("maMau") String maMau,
                                 Model model) {
        
        GioHangChiTietPK pk = new GioHangChiTietPK(maKH, maSanPham, maMau, size);
        
        gioHangChiTietService.delete(pk);
        
        model.addAttribute("message", "Sản phẩm đã được xóa khỏi giỏ hàng.");
        System.out.println("maSanPham: " + maSanPham);
        System.out.println("maKH: " + maKH);
        System.out.println("size: " + size);
        System.out.println("maMau: " + maMau);
        // Cập nhật tổng thành tiền của giỏ hàng
        
        GioHang gioHang = gioHangService.findById(maKH);
        int tongThanhTien = gioHangChiTietService.tinhTongThanhTien(maKH);
        gioHang.setTongThanhTien(tongThanhTien);
        gioHangService.update(gioHang);

        return "redirect:/home/cart/view";
    }



}
