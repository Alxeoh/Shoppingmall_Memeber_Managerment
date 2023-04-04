CREATE TABLE member_tbl_02(
custno NUMBER(6) PRIMARY KEY,
custname VARCHAR2(20),
phone VARCHAR2(13),
address VARCHAR2(60),
joindate DATE,
grade CHAR(1),
city CHAR(2)
);


CREATE TABLE money_tbl_02(
custno NUMBER(6),
salenol NUMBER(8),
pcost NUMBER(8),
amount NUMBER(4),
price NUMBER(8),
pcode VARCHAR2(4),
sdate DATE default sysdate,
PRIMARY KEY(custno, salenol)
);

Create view sum_sales as
SELECT m.custno, m.custname, m.grade, SUM(price) AS total_sales
FROM member_tbl_02 m
JOIN money_tbl_02 mm
ON m.custno = mm.custno
GROUP BY m.custno, m.custname, m.grade
ORDER BY sum(price) DESC;