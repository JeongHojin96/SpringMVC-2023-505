create database imagedb;
use imagedb;
drop table tbl_bbs;
select * from tbl_bbs;
create table tbl_bbs(
b_seq bigint primary key auto_increment,
b_title varchar(125),
b_content varchar(1000),
b_nickname varchar(125),
b_password varchar(125),
b_ccode varchar(6),
b_date varchar(10),
b_image varchar(125),
b_origin_image varchar(125),
b_viewcount bigint

);
drop table tbl_files;
select * from tbl_files;
create table tbl_files(
f_seq bigint primary key auto_increment,
f_bseq	bigint,
f_image	varchar(125),
f_origin_image varchar(125)
);

