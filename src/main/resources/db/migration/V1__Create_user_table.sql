create table USER
(
	ID INTEGER auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN VARCHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFY BIGINT,
	constraint USER_PK
		primary key (ID)
);

