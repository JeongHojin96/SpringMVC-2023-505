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
public class UsersDto {
	public String u_code;
	public String u_name;
	public String u_tel;
	public String u_addr;
}
