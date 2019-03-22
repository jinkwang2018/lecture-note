create table dmlemp
 	as
 		select * from emp;
 	alter table dmlemp
 	add constraint pk_dmlemp_empno primary key(empno);
  
  select * from dmlemp;
  
  
  
  select*from user_constraints where table_name = 'DMLEMP';

-----------------------------------------------------------------------------------------------------------------------
create table trans_A(
  num number,
  name varchar2(20)
);

create table trans_B(
  num number constraint pk_trans_B_num primary key,
  name varchar2(20)
);
select * from trans_A;
select * from trans_B;

select*from dept;

select deptno , dname , loc from dept where dname like '%a%';










-------------------------------------------------------------------------------------------------------------------------------------------------------------------프로젝트
CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    gender CHAR(4),
    email VARCHAR2(50),
    phonenumber  VARCHAR2(50)
);
select * from koreaMember;
delete  from koreaMember;


drop table koreaMember;
CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    age NUMBER ,
    gender CHAR(4),
    email VARCHAR2(50),
    ip   VARCHAR2(50)
)
select * from koreaMember;

create table k(thername varchar2(50), name varchar2(20), times varchar2(20), chair number);
insert into k VALUES('과천시시설관리공단','늑대아이', '10시', 30);
insert into k VALUES('과천시시설관리공단','늑대아이', '12시', 30);
insert into k VALUES('과천시시설관리공단','늑대아이', '14시', 30);
insert into k VALUES('과천시시설관리공단','늑대아이', '16시', 30);
insert into k VALUES('과천시시설관리공단','인셉션', '10시', 30);
insert into k VALUES('과천시시설관리공단','인셉션', '12시', 30);
insert into k VALUES('과천시시설관리공단','인셉션', '14시', 30);
insert into k VALUES('과천시시설관리공단','인셉션', '16시', 30);
insert into k VALUES('과천시시설관리공단','블랙팬셔', '10시', 30);
insert into k VALUES('과천시시설관리공단','블랙팬셔', '12시', 30);
insert into k VALUES('과천시시설관리공단','블랙팬셔', '14시', 30);
insert into k VALUES('과천시시설관리공단','블랙팬셔', '16시', 30);
commit;

select*from k;

CREATE TABLE testlist
(
    id VARCHAR2(50) PRIMARY KEY ,
    password VARCHAR2(50) NOT NULL,
    email VARCHAR2(50)
)
select*from testlist;

