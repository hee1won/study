package com.academy.study.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Spring0512Dto {
	private int id;
	private String customerName;
	private String contactName;
	private String postalCode;
	private String address;
	private String city;
	private String country;
	private String title;
	private String body;
	private LocalDateTime inserted;
	private int numOfReply;
}
