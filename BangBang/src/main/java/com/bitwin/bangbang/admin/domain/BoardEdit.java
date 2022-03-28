package com.bitwin.bangbang.admin.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardEdit {
	
	private int iidx;
	private String title;
	private String content;
	private String thumbOldName;
	private String photo1OldName;
	private String photo2OldName;
	private MultipartFile thumb;
	private MultipartFile photo1;
	private MultipartFile photo2;
	private String thumbName;
	private String photo1Name;
	private String photo2Name;
	
}
