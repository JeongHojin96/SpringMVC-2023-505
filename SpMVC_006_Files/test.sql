
평 가 내 용 배점 득점
SQL 작성
( 1 )
1. 다음 조건에 맞는 Oracle TableSpace를 생성하는 SQL을 
작성하시오. TableSpace 명 : myDB
DataFile 명 : “c:/app/data/myDB.dbf”
초기용량은 1MByte 으로 하며, 초기용량이 부족할 경우 1KByte 
씩 자동증가 하도록 설정
CREATE TABLESPACE myDB
DATAFILE 'c:/app/data/myDB.dbf'
SIZE 1M AUTOEXTEND ON NEXT 1K;
SQL 작성
( 2 ) 2. MySQL 의 Database를 iolistDB 이름으로 생성하시오. 5
CREATE DATABASE iolistDB;
SQL 작성
( 3 )
3. 테이블명세의 데이터타입을 완성하여 작성하고, 명세서 내용을 
화면캡춰하여 첨부하시오. 5
SQL 작성
( 4 )
4. MySQL SQL을 사용하여 다음 조건에 맞는 사용자를 생성하시오. userrname : korea, password !Biz8080
접근가능한 Host 주소 : localhost 와 192.168.0.% 
5
CREATE USER korea@localhost IDENTIFIED BY '!Biz8080’
CREATE USER korea@192.168.0.% IDENTIFIED BY '!Biz8080'
SQL 작성
( 5 )
5. 위에서 생성한 사용자에게 iolistDB 의 모든 테이블에 접근 할 수 
있는 권한을 부여하는 SQL을 작성하시오. 5
GRANT ALL PRIVILEGES ON iolistDB.* TO korea@localhost;
GRANT ALL PRIVILEGES ON iolistDB.* TO korea@192.168.0.%;
SQL 작성
( 6 )
6. MySQL SQL을 사용하여 테이블 명세서에 있는 3개의 테이블 
테이블 생성 코드를 작성하여 첨부하시오. 일련번호 칼럼은 
자동증가 옵션을 설정하시오. 5
CREATE TABLE tbl_iolist(
io_seq bigint PRIMARY KEY auto_increment,
io_date varchar(10) NOT NULL,
io_time varchar(10) NOT NULL,
io_pcode varchar(5) NOT NULL,
io_dcode varchar(4) NOT NULL,
io_inout varchar(1) NOT NULL,
io_qty int NOT NULL,
io_iprice int NOT NULL
);
CREATE TABLE tbl_dept(데이터베이스 구현 – 문제해결 시나리오(2023년 07월 12일) - 4 -
d_code varchar(4) PRIMARY KEY,
d_name varchar(125) NOT NULL,
d_ceo varchar(50) NOT NULL,
d_tel varchar(20) NOT NULL,
d_address varchar(125)
);
CREATE TABLE tbl_product(
p_code varchar(5) PRIMARY KEY,
p_name varchar(50) NOT NULL,
p_iprice int,
p_oprice int
);
SQL 작성
( 7 )
7. tbl_iolist, tbl_dept, tbl_product 테이블간에“참조무결성 
관계”가 성립되는지 검증하는 SQL을 작성하시오. 5
SELECT * FROM tbl_iolist
LEFT JOIN tbl_dept ON io_dcode = d_code
WHERE d_code is null;
SELECT * FROM tbl_iolist
LEFT JOIN tbl_product ON io_pcode = p_code
WHERE p_code is null;
※ 출력 결과가 없어야 함
SQL 작성
( 8 )
8. tbl_iolist, tbl_dept, tbl_product 테이블을 “참조무결성 
관계”를 설정하시오. 5
ALTER TABLE tbl_iolist
ADD CONSTRAINT f_dcode
FOREIGN KEY (io_dcode)
REFERENCES tbl_dept(d_code); 
ALTER TABLE tbl_iolist
ADD CONSTRAINT f_pcode
FOREIGN KEY (io_pcode)
REFERENCES tbl_product(p_code); 
SQL 작성
( 9 )
9. 매입매출 데이터중에서 거래일자가 2023-03-01부터 
2023-03-31인 데이터를 SELECTION 하는 SQL을 작성하시오. 5
SELECT *
 FROM tbl_iolist
WHERE io_date between '2023-03-01' and '2023-03-31';
또는
SELECT *데이터베이스 구현 – 문제해결 시나리오(2023년 07월 12일) - 5 -
 FROM tbl_iolist
WHERE io_date >= '2023-03-01' and io_date <= '2023-03-31';
SQL 작성
( 10 )
10. 매입매출 데이터중에서 거래구분 이 1(매입)이고, 거래수량이 60이상 70미만인 데이터를 SELECTION 하는 
SQL을 작성하시오. 5
SELECT *
 FROM tbl_iolist
WHERE io_inout = '1' 
 AND io_qty >= 60 
 AND io_qty < 70;
SQL 활용
( 1 )
11. tbl_iolist, tbl_dept, tbl_product 테이블의 구조를 확인하는 
SQL을 작성하시오 5
DESC tbl_iolist;
DESC tbl_product;
DESC tbl_dept;
SQL 활용
( 2 )
12. tbl_iolist, tbl_dept, tbl_product 테이블을 JOIN 하여 다음과 
같은 결과가 나타나도록 PROJECTION SQL을 작성하시오. ※ 표시되는 칼럼명 주의
5
SELECT io_seq, io_date, io_time, io_dcode AS 거래처코드, d_name AS 거래처명, 
io_pcode AS 상품코드, p_name AS 상품명, 
io_inout, io_qty, 
io_iprice AS 매입단가, 
io_oprice AS 매출단가
 FROM tbl_iolist
 LEFT JOIN tbl_dept on io_dcode = d_code
 LEFT JOIN tbl_product on io_pcode = p_code;데이터베이스 구현 – 문제해결 시나리오(2023년 07월 12일) - 6 -
SQL 활용
( 3 )
13. 상품코드, 상품명으로 GROUPING을 하고, 통계함수를 사용하여 
레코드 개수를 계산하는 SQL을 작성하시오. ※ 표시되는 칼럼명 주의
5
SELECT io_pcode AS 상품코드, p_name AS 상품명, COUNT(*) AS 레코드수
FROM tbl_iolist
LEFT JOIN tbl_product ON io_pcode = p_code
GROUP BY io_pcode;
SQL 활용
( 4 )
14. 샘플데이터의 거래구분, 상품코드, 상품명으로 GROUPING을 
하고 통계함수를 사용하여 매입합계와 매출합계를 출력하는 
SQL을 각각 작성하시오. ※ 표시되는 칼럼명 주의
5
SELECT io_inout AS 구분, io_pcode AS 상품코드, p_name AS 상품명, SUM(io_qty) AS 수량합계
FROM tbl_iolist
LEFT JOIN tbl_product ON io_pcode = p_code
GROUP BY io_inout, io_pcode, p_name
ORDER BY 상품코드, 구분 ASC;
SQL 활용
( 5 )
15. 샘플데이터의 “거래구분”항목은 1:매입, 2:매출입니다. 매입합계는 수량 * 매입단가의 총합이고, 매출합계는 수량 * 매출단가의 총합입니다. 통계함수를 
사용하여 전체거래의 매입합계와 매출합계를 계산하여 다음과 
같은 결과를 출력하는 SQL을 작성하시오. ※ 표시되는 칼럼명 주의 5
SELECT io_inout AS 거래구분, SUM(io_iprice) AS 매입합계, SUM(io_oprice) AS 매출합계
FROM tbl_iolist
GROUP BY io_inout;데이터베이스 구현 – 문제해결 시나리오(2023년 07월 12일) - 7 -
SQL 활용
( 6 )
16. 상품코드, 상품명으로 GROUPING을 하고, 통계함수를 사용하여
평균매입단가와, 평균매출단가를 출력하는 SQL을 작성하시오. ※ 표시되는 칼럼명 주의
5
SELECT io_pcode AS 상품코드, p_name AS 상품명, AVG(io_iprice) AS 평균매입단가, AVG(io_oprice) AS 평균매출단가
 FROM tbl_iolist
 LEFT JOIN tbl_product ON io_pcode = p_code
GROUP BY io_pcode, p_name
ORDER BY 상품코드 ASC;
SQL 활용
( 7 )
17. 다음과 같이 user 테이블을 작성하고, 작성된 테이블에 user 
정보를 추가하시오.
추가할 데이터
username nickname tel
hong 홍길동 010-1111-1111
lee 이몽룡 010-2222-2222
leem 임꺽정 010-3333-3333
5
INSERT INTO tbl_user(username, nickname, tel)
VALUES('hong','홍길동','010-1111-1111');
INSERT INTO tbl_user(username, nickname, tel)
VALUES('lee','이몽룡','010-2222-2222');
INSERT INTO tbl_user(username, nickname, tel)
VALUES('leem','임꺽정','010-3333-3333');
SQL 활용
( 8 )
18. 위의 user 테이블에 저장된 홍길동의 전화번호인 
010-1111-1111를 010-1111-5555 으로 변경하는 SQL을 
작성하시오. 반드시 PK를 조회한 후 변경을 실행하시오. 5
SELECT *
 FROM tbl_user
WHERE nickname = '홍길동'
 AND tel = '010-1111-1111';
 UPDATE tbl_user
 SET tel = '010-1111-5555'데이터베이스 구현 – 문제해결 시나리오(2023년 07월 12일) - 8 -
WHERE username = 'hong';
SQL 활용
( 9 )
19. 위의 user 테이블에 저장된 데이터중 임꺽정 데이터를 삭제하는 
SQL을 작성하시오. 반드시 PK를 조회한 후 삭제를 실행하시오. 5
SELECT *
 FROM tbl_user
WHERE nickname = '임꺽정';
DELETE
 FROM tbl_user
WHERE username = 'leem';
SQL 활용
( 10 )
20. 위의 user 테이블에 저장된 데이터중 nickname 에 “길”문자열이 
포함된 데이터를 SELECTION 하는 SQL을 작성하시오. ※ 중간문자열 검색
5
SELECT *FROM tbl_user
WHERE nickname LIKE '%길%';