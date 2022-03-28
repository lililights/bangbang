package com.bitwin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class paqVO {
	
	private int pqidx;
	private int uidx;
	private String title;
	private String content;
	private String reply;
	private Date regdate;
	private Date updatedate;
	
}
