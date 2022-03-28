package com.bitwin.bangbang.admin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewList {

	private int ridx;
	private int uidx;
	private int iidx;
	private String content;
	private int rating;
	private Date date;
	private String userName;
}
