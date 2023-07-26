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

drop table tbl_rent_table;

create table tbl_rent_book (
	rent_seq	bigint	NOT NULL	PRIMARY KEY	auto_increment,
	rent_date	varchar(10)	NOT NULL,		
	rent_return_date	varchar(10)	NOT NULL,		
	rent_bcode	varchar(13)	NOT NULL,		
	rent_mcode	varchar(6)	NOT NULL,		
	rent_return_yn	varchar(1),			
	rent_point	int,			
	rent_price	int			
);

select * from tbl_members;

select count(*) from tbl_books;
select * from tbl_books limit 10;

select count(*) from tbl_members;
select * from tbl_members limit 10;

commit;

select * from tbl_rent_book;

select * from tbl_rent_book R
left join tbl_members M
	on R.rent_mcode = M.m_code
left join tbl_books B
	on R.rent_bcode = B.b_code;