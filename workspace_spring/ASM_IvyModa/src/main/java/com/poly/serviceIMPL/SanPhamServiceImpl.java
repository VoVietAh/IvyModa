package com.poly.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.SanPhamDAO;
import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService{
@Autowired
SanPhamDAO dao;
	@Override
	public List<SanPham> findAll() {
		return dao.findAll();
	}

	@Override
	public SanPham findById(String Id) {
		return dao.getReferenceById(Id);
	}
	
	// Hàm tăng ký tự tiền tố (VD: "SPA" → "SPB", "SPZ" → "SQA")
	private String incrementPrefix(String prefix) {
	    char[] chars = prefix.toCharArray();

	    for (int i = chars.length - 1; i >= 0; i--) {
	        if (chars[i] < 'Z') { // Nếu chưa đến 'Z', tăng ký tự
	            chars[i]++;
	            return new String(chars);
	        } else {
	            chars[i] = 'A'; // Nếu là 'Z', đặt lại 'A' và tiếp tục tăng ký tự trước đó
	        }
	    }

	    return new String(chars); // Trả về prefix mới
	}

	@Override
	public String newSanPhamID() {
	    String maxCode = dao.findMaxProductCode(); // VD: "SPA99999"

	    if (maxCode == null || maxCode.isEmpty()) {
	        return "SPA00001"; // Nếu chưa có sản phẩm nào, bắt đầu từ "SPA00001"
	    }

	    String prefix = maxCode.substring(0, 3); // "SPA"
	    String numberPart = maxCode.substring(3); // "99999"

	    int number = Integer.parseInt(numberPart); 

	    if (number < 99999) {
	        number++; // Tăng số bình thường
	    } else {
	        prefix = incrementPrefix(prefix); // Tăng ký tự nếu số đạt 99999
	        number = 1; // Reset số về 1
	    }

	    return String.format("%s%05d", prefix, number); 
	}





	@Override
	public void create(SanPham sanPham) {
		dao.save(sanPham);
	}

	@Override
	public void upadte(SanPham sanPham) {
		dao.save(sanPham);
	}

	@Override
	public void deleteByMaSanPham(String maSanPham) {
		dao.deleteByMaSanPham(maSanPham);
	}

	@Override
	public List<SanPham> findAllByGender(Boolean gioiTinh) {
		return dao.findAllByGender(gioiTinh);
	}




}
