-- RentBook root 접속

create database rentbookdb;
use rentBookDb;

create table tbl_books (
	b_code	varchar(12)	NOT NULL	PRIMARY KEY,
	b_name	varchar(125)	NOT NULL,	
	b_auther	varchar(125)	NOT NULL,	
	b_comp	varchar(125),		
	b_year	int	NOT NULL,	
	b_iprice	int,		
	b_rprice	int	NOT NULL	
);

desc tbl_books;
drop table tbl_books;

show tables;

insert into tbl_books (
	b_code, b_name,	b_auther, b_comp, b_year, b_iprice, b_rprice
    ) values ( '001', '자바야 놀자', '야놀자', '놀자출판', 2010, 20000, 2000
);

select * from tbl_books ;

commit;

use rentbookdb;

create table tbl_members (
	m_code	varchar(6)	not null	PRIMARY KEY,
	m_name	varchar(125)	not null,
	m_tel	varchar(15)	not null,
	m_addr	varchar(125)
);

desc tbl_members;

commit;

select * from tbl_members;

create table tbl_rentbook (
	rent_seq	bigint	NOT NULL	PRIMARY KEY	auto_increment,
	rent_date	varchar(10)	NOT NULL,		
	rent_return_date	varchar(10)	NOT NULL,		
	rent_bcode	varchar(13)	NOT NULL,		
	rent_mcode	varchar(6)	NOT NULL,		
	rent_return_yn	varchar(1),			
	rent_point	int,			
	rent_price	int			
);

