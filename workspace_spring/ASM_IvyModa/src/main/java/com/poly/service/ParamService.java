package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ParamService {

	  @Autowired
	    HttpServletRequest request;

	    public String getString(String name, String defaultValue) {
	        return Optional.ofNullable(request.getParameter(name)).orElse(defaultValue);
	    }

	    public int getInt(String name, int defaultValue) {
	        try {
	            return Integer.parseInt(request.getParameter(name));
	        } catch (NumberFormatException e) {
	            return defaultValue;
	        }
	    }

	    public double getDouble(String name, double defaultValue) {
	        try {
	            return Double.parseDouble(request.getParameter(name));
	        } catch (NumberFormatException e) {
	            return defaultValue;
	        }
	    }

	    public boolean getBoolean(String name, boolean defaultValue) {
	        String param = request.getParameter(name);
	        return param != null ? Boolean.parseBoolean(param) : defaultValue;
	    }

	    public Date getDate(String name, String pattern) {
	        String value = request.getParameter(name);
	        if (value == null) return null;
	        try {
	            return new SimpleDateFormat(pattern).parse(value);
	        } catch (ParseException e) {
	            throw new RuntimeException("Invalid date format", e);
	        }
	    }

	    public File save(MultipartFile file, String path) {
	        if (file.isEmpty()) return null;
	        try {
	            File dest = new File(path + file.getOriginalFilename());
	            file.transferTo(dest);
	            return dest;
	        } catch (IOException e) {
	            throw new RuntimeException("File saving failed", e);
	        }
	    }
	}

