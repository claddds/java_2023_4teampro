-- customer���̺� cust_birth, cust_phone(��ȭ��ȣ)�� date, numberŸ�Կ��� varchar2(50)���� ����
alter table customer MODIFY cust_birth varchar2(50);
alter table customer MODIFY cust_phone varchar2(50);

-- customer���̺� ����Ʈ �߰�
alter table customer add point number;

-- point���̺� point_date(��¥)dateŸ�Կ��� varchar2(50)���� ����
alter table point MODIFY point_date varchar2(50);

-- ticket���̺� movie_date(�󿵳�¥) dateŸ�Կ��� varchar2(50)���� ����
alter table ticket MODIFY movie_date varchar2(50);

-- movie_Schedule ���̺� movie_date(�󿵳�¥) dateŸ�Կ��� varchar2(50)���� ����
alter table movie_Schedule MODIFY movie_date varchar2(50);

-- s_order ���̺� o_date(�ֹ��ð�) dateŸ�Կ��� varchar2(50)���� ����
alter table s_order MODIFY o_date varchar2(50);

-- s_product���̺� in_order(�ֹ�����), in_date(�԰�����) dateŸ�Կ��� varchar2(50)���� ����
alter table s_product MODIFY in_order varchar2(50);
alter table s_product MODIFY in_date varchar2(50);
commit;