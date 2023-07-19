package com.callor.car.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
	private long c_seq;
	private String c_cate;
	private String c_sdate;
	private String c_stime;
	private int c_skm;
	private String c_edate;
	private String c_etime;
	private int c_ekm;
	private String c_place;
	private String c_fee;
}
