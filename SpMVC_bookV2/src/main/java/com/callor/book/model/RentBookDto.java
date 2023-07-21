package com.callor.book.model;

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
public class RentBookDto {

	public long rent_seq;
	public String rent_date;
	public String rent_retur_date;
	public String rent_bcode;
	public String rent_ucode;
	public String rent_retur_yn;
	public int rent_point;

}
