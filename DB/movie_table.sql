CREATE TABLE CUSTOMER (
	cust_id	varchar2(50) NOT NULL primary key,
	cust_password varchar2(50) NOT NULL,
	cust_name varchar2(50) NOT NULL,
	cust_birth date,
	cust_phone number,
	admin_yn char(1) CONSTRAINT CUSTOMER_admin_yn_CK CHECK(admin_yn ='0' or admin_yn ='0'),
	delete_yn char(1) CONSTRAINT CUSTOMER_delete_yn_CK CHECK(delete_yn ='0' or delete_yn ='0')
);
-- �����Ͱ� boolean�� ���� char(1)�� ������ 0-> false 1-> true�� �����Ѵ�.

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

-- ����Ʈ ���̺� cust_id�� �ܷ�Ű �����ϱ�
alter table POINT
add CONSTRAINT cust_id foreign KEY(cust_id) REFERENCES CUSTOMER(cust_id);

-- ��¥�� �ð����� ������ Ÿ������ ����
-- ���� dateŸ���� ��-��-�ϸ� ǥ�õǱ� ������ ������ �ʿ��ϴ�.
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

-- ��ȭ������ ���̺� movie_id�� �ܷ�Ű �����ϱ�
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

-- Ƽ�� ���̺� cust_id�� �ܷ�Ű �����ϱ�
alter table TICKET
add CONSTRAINT  ticket_cust_id foreign KEY(cust_id) REFERENCES CUSTOMER(cust_id);

-- Ƽ�� ���̺� movie_id�� �ܷ�Ű �����ϱ�
alter table TICKET
add CONSTRAINT  ticket_movie_id foreign KEY(movie_id) REFERENCES MOVIE(movie_id);

commit;
