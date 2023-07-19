-- MyCar root 화면
create database mycarDB;
use mycarDB;

create table tbl_carmanager (
	c_seq	bigint		primary key	auto_increment,
	c_carnum	varchar(15)	not null,		
	c_qty	varchar(10)	not null,		
	c_username	varchar(20)	not null,		
	c_sdate	varchar(10)	not null,		
	c_stime	varchar(10)	not null,		
	c_goal	varchar(30),		
	c_edate	varchar(15),			
	c_etime	varchar(10),			
	c_skm	int,			
	c_ekm	int,			
	c_cost	int
    );
    
    desc tbl_carmanager;
    
    insert into tbl_carmanager(
    c_carnum, c_qty, c_username, c_sdate, c_stime, c_skm, c_ekm)
    values('001','출근','callor','2023-07-01','07:00',3000,3010);
    
    insert into tbl_carmanager(
    c_carnum, c_qty, c_username, c_sdate, c_stime, c_skm, c_ekm)
    values('001','퇴근','callor','2023-07-01','18:00',3010,3020);
    
    insert into tbl_carmanager(
    c_carnum, c_qty, c_username, c_sdate, c_stime, c_skm, c_ekm)
    values('002','출장','callor','2023-07-01','07:00',13000,13300);
    
    insert into tbl_carmanager(
    c_carnum, c_qty, c_username, c_sdate, c_stime, c_skm, c_ekm)
    values('002','복귀','callor','2023-07-01','18:00',13300,13600);

	commit;

    select * from tbl_carmanager
    where c_carnum = '001'
    order by c_sdate desc, c_stime desc
    limit 1;
    
    select * from tbl_carmanager;
    