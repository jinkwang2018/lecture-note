/* �ʴ�޼��� */
CREATE TABLE INVITEMSG (
	userid VARCHAR2(100) NOT NULL, /* ���̵� */
	projectnum NUMBER NOT NULL, /* ������Ʈ�ѹ� */
	inviteuserId VARCHAR2(100) NOT NULL, /* �ʴ����ο��Ǿ��̵� */
	msgdate DATE NOT NULL /* �޼���������¥ */
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

/* ��� */
CREATE TABLE REPLY (
	replynum NUMBER NOT NULL, /* ��۳ѹ� */
	userid VARCHAR2(100) NOT NULL, /* ���̵� */
	cardnum NUMBER NOT NULL, /* ī��ѹ� */
	replycontents VARCHAR2(255) NOT NULL /* ���� */
);

/* ī���� ��� */
CREATE TABLE CARDMEMBER (
	cardnum NUMBER NOT NULL, /* ī��ѹ� */
	userid VARCHAR2(100) NOT NULL /* ���̵� */
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

/* ����Ʈ */
CREATE TABLE LIST (
	listnum NUMBER NOT NULL, /* ����Ʈ�ѹ� */
	boardnum NUMBER NOT NULL, /* ����ѹ� */
	listname VARCHAR2(30) NOT NULL, /* ����Ʈ�� */
	listsequential NUMBER NOT NULL, /* ����Ʈ���� */
	deleteok NUMBER NOT NULL /* �������� */
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

/* ��� */
CREATE TABLE MEMBERGRADE (
	grade NUMBER NOT NULL, /* ȸ����� */
	gradename VARCHAR2(10) NOT NULL /* ��� */
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

/* �� */
CREATE TABLE TEAM (
	userid VARCHAR2(100) NOT NULL, /* ���̵� */
	projectnum NUMBER NOT NULL, /* ������Ʈ�ѹ� */
	grade NUMBER NOT NULL, /* ȸ����� */
	projectlastmoddate DATE NOT NULL /* ������������¥ */
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

/* ������Ʈ */
CREATE TABLE PROJECT (
	projectnum NUMBER NOT NULL, /* ������Ʈ�ѹ� */
	projectname VARCHAR2(255) NOT NULL, /* ������Ʈ�� */
	projectstartdate DATE NOT NULL, /* ������Ʈ���۳�¥ */
	projectenddate DATE, /* ������Ʈ���ᳯ¥ */
	deleteok NUMBER NOT NULL /* �������� */
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

/* ī�� */
CREATE TABLE CARD (
	cardnum NUMBER NOT NULL, /* ī��ѹ� */
	listnum NUMBER NOT NULL, /* ����Ʈ�ѹ� */
	cardname VARCHAR2(255) NOT NULL, /* ī��� */
	cardcontents VARCHAR2(1000), /* ī�峻�� */
	cardsequential NUMBER NOT NULL, /* ī����� */
	deleteok NUMBER NOT NULL /* �������� */
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

/* ȸ�� */
CREATE TABLE MEMBER (
	userid VARCHAR2(100) NOT NULL, /* ���̵� */
	userpwd VARCHAR2(255) NOT NULL, /* ��й�ȣ */
	usernicname VARCHAR2(50) NOT NULL, /* �г��� */
	userprofile VARCHAR2(500) /* �����ʻ��� */
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

/* ���Ͼ��ε� */
CREATE TABLE UPLOAD (
	filenum NUMBER NOT NULL, /* ���ϳѹ� */
	cardnum NUMBER NOT NULL, /* ī��ѹ� */
	filepath VARCHAR2(255) NOT NULL, /* ���ε����ϸ� */
	originfilename VARCHAR2(255) NOT NULL /* ���ε�����ϸ� */
);

/* üũ�ڽ� */
CREATE TABLE CHECKBOX (
	checknum NUMBER NOT NULL, /* üũ�ѹ� */
	cardnum NUMBER NOT NULL, /* ī��ѹ� */
	checked NUMBER NOT NULL, /* üũ���� */
	checkboxcontents VARCHAR2(50) NOT NULL /* üũ�ڽ����� */
);

/* ���� */
CREATE TABLE BOARD (
	boardnum NUMBER NOT NULL, /* ����ѹ� */
	projectnum NUMBER NOT NULL, /* ������Ʈ�ѹ� */
	boardtitle VARCHAR2(30) NOT NULL, /* �������� */
	detail VARCHAR2(50), /* ������ */
	boardstartdate DATE NOT NULL, /* ������۳�¥ */
	boardenddate DATE NOT NULL, /* �������ᳯ¥ */
	label VARCHAR2(30), /* �� */
	deleteok NUMBER NOT NULL, /* �������� */
	completeok NUMBER NOT NULL /* �ϷῩ�� */
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


--������
create sequence project_idx;

create sequence board_idx;

create sequence list_idx;

create sequence card_idx;


--�ʱ� ��
insert into membergrade(GRADE, GRADENAME) values(0,'������');
insert into membergrade(GRADE, GRADENAME) values(1,'����');

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS'; 

commit;