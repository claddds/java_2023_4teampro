CREATE TABLE CUSTOMER (
	cust_id	varchar2(50) NOT NULL primary key,
	cust_password varchar2(50) NOT NULL,
	cust_name varchar2(50) NOT NULL,
	cust_birth date,
	cust_phone number,
	admin_yn char(1) CONSTRAINT CUSTOMER_admin_yn_CK CHECK(admin_yn ='0' or admin_yn ='0'),
	delete_yn char(1) CONSTRAINT CUSTOMER_delete_yn_CK CHECK(delete_yn ='0' or delete_yn ='0')
);
-- 데이터값 boolean이 없어 char(1)로 저장해 0-> false 1-> true로 저장한다.

CREATE TABLE MOVIE (
    movie_id varchar2(50) NOT NULL primary key,
	movie_name varchar2(50) NOT NULL,
	view_age number
);

CREATE TABLE THEATER (
	theater_id	varchar2(50) NOT NULL primary key,
	seat_count	number	NOT NULL
);

CREATE TABLE POINT (
    cust_id varchar2(50) not null,
	point_date date	default sysdate,
	charge_point number,
	used_point number,
	remaining_point	number	NOT NULL
);

-- 포인트 테이블에 cust_id에 외래키 설정하기
alter table POINT
add CONSTRAINT cust_id foreign KEY(cust_id) REFERENCES CUSTOMER(cust_id);

-- 날짜를 시간까지 나오는 타입으로 변경
-- 기존 date타입은 년-월-일만 표시되기 때문에 변경이 필요하다.
SELECT * FROM NLS_SESSION_PARAMETERS;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

CREATE TABLE MOVIE_SCHEDULE(
	movie_id varchar2(50),
	movie_name	varchar2(50),
	movie_date	date,
	start_time	varchar2(50),
	end_time varchar2(50),
	poster_img	varchar2(50),
	theater_id varchar2(50)
);

-- 영화스케줄 테이블에 movie_id에 외래키 설정하기
alter table MOVIE_SCHEDULE
add CONSTRAINT  movie_id foreign KEY(movie_id) REFERENCES MOVIE(movie_id);

CREATE TABLE TICKET (
	ticket_num	number	NOT NULL primary key,
	movie_id varchar2(50)	NOT NULL,
	cust_id	varchar2(50)	NOT NULL,
	movie_name	varchar2(50) NOT NULL,
	theater_id	varchar2(50)	NOT NULL,
	movie_date	date	NOT NULL,
	start_time	varchar2(50)	NOT NULL,
	end_time	varchar2(50)	NOT NULL,
	theater_seat	varchar2(50)	NOT NULL
);

-- 티켓 테이블에 cust_id에 외래키 설정하기
alter table TICKET
add CONSTRAINT  ticket_cust_id foreign KEY(cust_id) REFERENCES CUSTOMER(cust_id);

-- 티켓 테이블에 movie_id에 외래키 설정하기
alter table TICKET
add CONSTRAINT  ticket_movie_id foreign KEY(movie_id) REFERENCES MOVIE(movie_id);

commit;
