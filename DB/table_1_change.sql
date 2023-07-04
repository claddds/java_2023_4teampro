-- customer테이블에 cust_birth, cust_phone(전화번호)를 date, number타입에서 varchar2(50)으로 변경
alter table customer MODIFY cust_birth varchar2(50);
alter table customer MODIFY cust_phone varchar2(50);

-- customer테이블에 포인트 추가
alter table customer add point number;

-- point테이블 point_date(날짜)date타입에서 varchar2(50)으로 변경
alter table point MODIFY point_date varchar2(50);

-- ticket테이블에 movie_date(상영날짜) date타입에서 varchar2(50)으로 변경
alter table ticket MODIFY movie_date varchar2(50);

-- movie_Schedule 테이블에 movie_date(상영날짜) date타입에서 varchar2(50)으로 변경
alter table movie_Schedule MODIFY movie_date varchar2(50);

-- s_order 테이블에 o_date(주문시간) date타입에서 varchar2(50)으로 변경
alter table s_order MODIFY o_date varchar2(50);

-- s_product테이블에 in_order(주문일자), in_date(입고일자) date타입에서 varchar2(50)으로 변경
alter table s_product MODIFY in_order varchar2(50);
alter table s_product MODIFY in_date varchar2(50);
commit;