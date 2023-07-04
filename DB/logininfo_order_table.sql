CREATE TABLE s_order (
    cust_id    varchar2(50)    NOT NULL,
    p_name    varchar2(50)    NOT NULL,
    o_count    number    NOT NULL,
    menunumber    number    NOT NULL,
    out_price    number    NOT NULL,
    o_date    date    NOT NULL
);

CREATE TABLE s_product (
    p_num    varchar2(50)    NOT NULL,
    p_name    varchar2(50)    NOT NULL,
    p_total    number    NOT NULL,
    in_price    number    NOT NULL,
    in_order    date    NOT NULL,
    o_su    number    NOT NULL,
    in_date    date    NOT NULL,
    in_su    number    NULL,
    total_su    number    NOT NULL
);
CREATE TABLE LOGIN_INFO(
cust_id varchar2(50) NOT NULL primary key,
cust_name varchar2(50),
point number
);
commit;