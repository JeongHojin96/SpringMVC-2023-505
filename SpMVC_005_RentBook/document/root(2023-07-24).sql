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