create database boardtestdb;
use boardtestdb;

create table tbl_boardtest(
	b_seq bigint not null primary key auto_increment,
    b_title varchar(125) not null,
    b_content varchar(1000) not null,
    b_icode varchar(125),
    b_nickname varchar(125),
    b_password varchar(125) not null,
    b_ccode varchar(6) not null,
    b_date varchar(10) not null,
    b_viewcount bigint
);

desc tbl_boardtest;

create table tbl_categorytest(
c_code varchar(6) not null primary key,
c_title varchar(125) not null
);

create table tbl_imagetest(
i_code varchar(6) not null primary key,
i_url varchar(125) not null
);

insert into tbl_boardtest (
b_seq, b_title, b_content, b_icode,
b_nickname, b_password, b_ccode, b_date, b_viewcount
) values ( 
#{b_seq}, #{b_title}, #{b_content}, #{b_icode},
#{b_nickname}, #{b_password}, #{b_ccode}, #{b_date}, #{b_viewcount}
);