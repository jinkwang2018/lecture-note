/* 초대메세지 */
CREATE TABLE INVITEMSG (
	userid VARCHAR2(100) NOT NULL, /* 아이디 */
	projectnum NUMBER NOT NULL, /* 프로젝트넘버 */
	inviteuserId VARCHAR2(100) NOT NULL, /* 초대한인원의아이디 */
	msgdate DATE NOT NULL /* 메세지받은날짜 */
);

CREATE UNIQUE INDEX PK_INVITEMSG
	ON INVITEMSG (
		userid ASC,
		projectnum ASC,
		inviteuserId ASC
	);

ALTER TABLE INVITEMSG
	ADD
		CONSTRAINT PK_INVITEMSG
		PRIMARY KEY (
			userid,
			projectnum,
			inviteuserId
		);

/* 댓글 */
CREATE TABLE REPLY (
	replynum NUMBER NOT NULL, /* 댓글넘버 */
	userid VARCHAR2(100) NOT NULL, /* 아이디 */
	cardnum NUMBER NOT NULL, /* 카드넘버 */
	replycontents VARCHAR2(255) NOT NULL /* 내용 */
);

/* 카드담당 멤버 */
CREATE TABLE CARDMEMBER (
	cardnum NUMBER NOT NULL, /* 카드넘버 */
	userid VARCHAR2(100) NOT NULL /* 아이디 */
);

CREATE UNIQUE INDEX PK_CARDMEMBER
	ON CARDMEMBER (
		cardnum ASC,
		userid ASC
	);

ALTER TABLE CARDMEMBER
	ADD
		CONSTRAINT PK_CARDMEMBER
		PRIMARY KEY (
			cardnum,
			userid
		);

/* 리스트 */
CREATE TABLE LIST (
	listnum NUMBER NOT NULL, /* 리스트넘버 */
	boardnum NUMBER NOT NULL, /* 보드넘버 */
	listname VARCHAR2(30) NOT NULL, /* 리스트명 */
	listsequential NUMBER NOT NULL, /* 리스트순서 */
	deleteok NUMBER NOT NULL /* 삭제여부 */
);

CREATE UNIQUE INDEX PK_LIST
	ON LIST (
		listnum ASC
	);

ALTER TABLE LIST
	ADD
		CONSTRAINT PK_LIST
		PRIMARY KEY (
			listnum
		);

/* 등급 */
CREATE TABLE MEMBERGRADE (
	grade NUMBER NOT NULL, /* 회원등급 */
	gradename VARCHAR2(10) NOT NULL /* 등급 */
);

CREATE UNIQUE INDEX PK_MEMBERGRADE
	ON MEMBERGRADE (
		grade ASC
	);

ALTER TABLE MEMBERGRADE
	ADD
		CONSTRAINT PK_MEMBERGRADE
		PRIMARY KEY (
			grade
		);

/* 팀 */
CREATE TABLE TEAM (
	userid VARCHAR2(100) NOT NULL, /* 아이디 */
	projectnum NUMBER NOT NULL, /* 프로젝트넘버 */
	grade NUMBER NOT NULL, /* 회원등급 */
	projectlastmoddate DATE NOT NULL /* 마지막수정날짜 */
);

CREATE UNIQUE INDEX PK_TEAM
	ON TEAM (
		userid ASC,
		projectnum ASC
	);

ALTER TABLE TEAM
	ADD
		CONSTRAINT PK_TEAM
		PRIMARY KEY (
			userid,
			projectnum
		);

/* 프로젝트 */
CREATE TABLE PROJECT (
	projectnum NUMBER NOT NULL, /* 프로젝트넘버 */
	projectname VARCHAR2(255) NOT NULL, /* 프로젝트명 */
	projectstartdate DATE NOT NULL, /* 프로젝트시작날짜 */
	projectenddate DATE, /* 프로젝트종료날짜 */
	deleteok NUMBER NOT NULL /* 삭제여부 */
);

CREATE UNIQUE INDEX PK_PROJECT
	ON PROJECT (
		projectnum ASC
	);

ALTER TABLE PROJECT
	ADD
		CONSTRAINT PK_PROJECT
		PRIMARY KEY (
			projectnum
		);

/* 카드 */
CREATE TABLE CARD (
	cardnum NUMBER NOT NULL, /* 카드넘버 */
	listnum NUMBER NOT NULL, /* 리스트넘버 */
	cardname VARCHAR2(255) NOT NULL, /* 카드명 */
	cardcontents VARCHAR2(1000), /* 카드내용 */
	cardsequential NUMBER NOT NULL, /* 카드순서 */
	deleteok NUMBER NOT NULL /* 삭제여부 */
);

CREATE UNIQUE INDEX PK_CARD
	ON CARD (
		cardnum ASC
	);

ALTER TABLE CARD
	ADD
		CONSTRAINT PK_CARD
		PRIMARY KEY (
			cardnum
		);

/* 회원 */
CREATE TABLE MEMBER (
	userid VARCHAR2(100) NOT NULL, /* 아이디 */
	userpwd VARCHAR2(255) NOT NULL, /* 비밀번호 */
	usernicname VARCHAR2(50) NOT NULL, /* 닉네임 */
	userprofile VARCHAR2(500) /* 프로필사진 */
);

CREATE UNIQUE INDEX PK_MEMBER
	ON MEMBER (
		userid ASC
	);

ALTER TABLE MEMBER
	ADD
		CONSTRAINT PK_MEMBER
		PRIMARY KEY (
			userid
		);

/* 파일업로드 */
CREATE TABLE UPLOAD (
	filenum NUMBER NOT NULL, /* 파일넘버 */
	cardnum NUMBER NOT NULL, /* 카드넘버 */
	filepath VARCHAR2(255) NOT NULL, /* 업로드파일명 */
	originfilename VARCHAR2(255) NOT NULL /* 업로드실파일명 */
);

/* 체크박스 */
CREATE TABLE CHECKBOX (
	checknum NUMBER NOT NULL, /* 체크넘버 */
	cardnum NUMBER NOT NULL, /* 카드넘버 */
	checked NUMBER NOT NULL, /* 체크여부 */
	checkboxcontents VARCHAR2(50) NOT NULL /* 체크박스내용 */
);

/* 보드 */
CREATE TABLE BOARD (
	boardnum NUMBER NOT NULL, /* 보드넘버 */
	projectnum NUMBER NOT NULL, /* 프로젝트넘버 */
	boardtitle VARCHAR2(30) NOT NULL, /* 보드제목 */
	detail VARCHAR2(50), /* 디테일 */
	boardstartdate DATE NOT NULL, /* 보드시작날짜 */
	boardenddate DATE NOT NULL, /* 보드종료날짜 */
	label VARCHAR2(30), /* 라벨 */
	deleteok NUMBER NOT NULL, /* 삭제여부 */
	completeok NUMBER NOT NULL /* 완료여부 */
);

CREATE UNIQUE INDEX PK_BOARD
	ON BOARD (
		boardnum ASC
	);

ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD
		PRIMARY KEY (
			boardnum
		);

ALTER TABLE INVITEMSG
	ADD
		CONSTRAINT FK_MEMBER_TO_INVITEMSG
		FOREIGN KEY (
			userid
		)
		REFERENCES MEMBER (
			userid
		);

ALTER TABLE INVITEMSG
	ADD
		CONSTRAINT FK_PROJECT_TO_INVITEMSG
		FOREIGN KEY (
			projectnum
		)
		REFERENCES PROJECT (
			projectnum
		);

ALTER TABLE INVITEMSG
	ADD
		CONSTRAINT FK_MEMBER_TO_INVITEMSG2
		FOREIGN KEY (
			inviteuserId
		)
		REFERENCES MEMBER (
			userid
		);

ALTER TABLE REPLY
	ADD
		CONSTRAINT FK_CARD_TO_REPLY
		FOREIGN KEY (
			cardnum
		)
		REFERENCES CARD (
			cardnum
		);

ALTER TABLE REPLY
	ADD
		CONSTRAINT FK_MEMBER_TO_REPLY
		FOREIGN KEY (
			userid
		)
		REFERENCES MEMBER (
			userid
		);

ALTER TABLE CARDMEMBER
	ADD
		CONSTRAINT FK_CARD_TO_CARDMEMBER
		FOREIGN KEY (
			cardnum
		)
		REFERENCES CARD (
			cardnum
		);

ALTER TABLE CARDMEMBER
	ADD
		CONSTRAINT FK_MEMBER_TO_CARDMEMBER
		FOREIGN KEY (
			userid
		)
		REFERENCES MEMBER (
			userid
		);

ALTER TABLE LIST
	ADD
		CONSTRAINT FK_BOARD_TO_LIST
		FOREIGN KEY (
			boardnum
		)
		REFERENCES BOARD (
			boardnum
		);

ALTER TABLE TEAM
	ADD
		CONSTRAINT FK_MEMBERGRADE_TO_TEAM
		FOREIGN KEY (
			grade
		)
		REFERENCES MEMBERGRADE (
			grade
		);

ALTER TABLE TEAM
	ADD
		CONSTRAINT FK_MEMBER_TO_TEAM
		FOREIGN KEY (
			userid
		)
		REFERENCES MEMBER (
			userid
		);

ALTER TABLE TEAM
	ADD
		CONSTRAINT FK_PROJECT_TO_TEAM
		FOREIGN KEY (
			projectnum
		)
		REFERENCES PROJECT (
			projectnum
		);

ALTER TABLE CARD
	ADD
		CONSTRAINT FK_LIST_TO_CARD
		FOREIGN KEY (
			listnum
		)
		REFERENCES LIST (
			listnum
		);

ALTER TABLE UPLOAD
	ADD
		CONSTRAINT FK_CARD_TO_UPLOAD
		FOREIGN KEY (
			cardnum
		)
		REFERENCES CARD (
			cardnum
		);

ALTER TABLE CHECKBOX
	ADD
		CONSTRAINT FK_CARD_TO_CHECKBOX
		FOREIGN KEY (
			cardnum
		)
		REFERENCES CARD (
			cardnum
		);

ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_PROJECT_TO_BOARD
		FOREIGN KEY (
			projectnum
		)
		REFERENCES PROJECT (
			projectnum
		);


--시퀀스
create sequence project_idx;

create sequence board_idx;

create sequence list_idx;

create sequence card_idx;


--초기 값
insert into membergrade(GRADE, GRADENAME) values(0,'관리자');
insert into membergrade(GRADE, GRADENAME) values(1,'팀원');

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS'; 

commit;