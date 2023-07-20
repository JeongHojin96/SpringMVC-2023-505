use mycarDB;

create table tbl_users (
	username	varchar(15)		primary key,
	password	varchar(225)	not null,	
	u_name	varchar(20)	not null,	
	u_nickname	varchar(20)	,	
	u_tel	varchar(15)	,	
	u_role	varchar(15)	not null	
);

desc tbl_users;

drop table tbl_carmanager;
drop table tbl_users;
show tables;

desc tbl_users;



insert into tbl_users(username, password, u_name, u_nickname, u_tel, u_role)
values('callor', '12341234', '홍길동', '길동아','','admin');

drop table tbl_users;

select * from tbl_users;