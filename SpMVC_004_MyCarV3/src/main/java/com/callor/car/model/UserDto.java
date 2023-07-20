package com.callor.car.model;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private String username; // varchar(15)
	private String password; // varchar(225)
	private String u_name; // varchar(20)
	private String u_nickname; // varchar(20)
	private String u_tel; // varchar(15)
	private String u_role; // varchar(15)

}
