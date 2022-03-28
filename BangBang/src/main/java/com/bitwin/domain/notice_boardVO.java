package com.bitwin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class notice_boardVO {
	
	private int nidx;
	private String title;
	private String content;
	private Date regdate;
	private Date updatedate;
	
}
