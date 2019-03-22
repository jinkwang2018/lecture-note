//EMP 복사 테이블을 만듭니다. 
create table copyemp
as
  select * from emp;
  
//DEPT 복사 테이블을 만듭니다. 
create table copydept
as
  select * from dept;

 //관리자 로그인 리스트 테이블을 만듭니다  
create table adminlist(
userid varchar2(20) not null,
pwd varchar2(20) not null
);

//관리자를 입력
insert into adminlist values('admin', '1004');
insert into adminlist values('adminkim', '1234');