package com.bitwin.bangbang.admin.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {

	private int iidx;
	private String title;
	private String content;
	private Date date;
	private int hits;
	private String thumb;
	private String photo1;
	private String photo2;
	
}