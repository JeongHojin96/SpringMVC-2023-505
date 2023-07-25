package com.callor.rent.models;

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
public class MemberDto {

	public String m_code;// varchar(6)
	public String m_name;// varchar(125)
	public String m_tel;// varchar(125)
	public String m_addr;// varchar(125)

}
