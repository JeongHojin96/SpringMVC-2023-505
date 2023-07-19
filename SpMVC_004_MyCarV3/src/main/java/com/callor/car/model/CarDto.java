package com.callor.car.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
	private long c_seq;
	private String c_carnum;
	private String c_qty;
	private String c_username;
	private String c_sdate;
	private String c_stime;
	private String c_goal;
	private String c_edate;
	private String c_etime;
	private int c_skm;
	private int c_ekm;
	private int c_cost;
}
