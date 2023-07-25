create database bookdb;
use bookdb;

create table tbl_books (
	b_code	varchar(6)	not null	primary key,
	b_name	varchar(125)	not null,
	b_auther	varchar(125)	not null,
	b_comp	varchar(125),	
	b_year	int	not null,
	b_iprice	int,
	b_rprice	int	not null
);


create table tbl_users (
u_code	varchar(6)	not null	primary key,
u_name	varchar(125)	not null,
u_tel	varchar(125),
u_addr	varchar(125)
);

create table tbl_rent_book (
	rent_seq	bigint	not null	primary key,
    rent_date	varchar(30)	not null,
    rent_return_date	varchar(10)	not null,
    rent_bcode	varchar(6)	not null,
    rent_ucode	varchar(6)	not null,
    rent_retur_yn	varchar(1),
    rent_point	int
);

desc tbl_books;
desc tbl_users;
desc tbl_rent_book;

insert into tbl_books
  		(b_code, b_name, b_auther, b_comp, b_year, b_iprice, b_rprice)
  		values
        ('A00005', 'ㅇ', '책1', 'ㅇ',1,1,1);
        
        select * from tbl_books
		where b_auther Like '%책%';

commit;

insert into tbl_users
( u_code,
u_name,
u_tel,
u_addr)
values
('a00001','d','d','d');

update tbl_users set
u_name = ,
u_tel = 'dd',
u_addr = 'dd'
where u_code = 'a00001';

select * from tbl_users;