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
@Builder
public class BooksDto {

	public String b_code;
	public String b_name;
	public String b_auther;
	public String b_comp;
	public int b_year;
	public int b_iprice;
	public int b_rprice;
	
}
