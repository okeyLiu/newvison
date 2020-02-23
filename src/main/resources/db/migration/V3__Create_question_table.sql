create table question
(
	id int auto_increment,
	title varchar(50),
	description text,
	GMT_CREATE BIGINT,
	GMT_MODIFY BIGINT,
	creator int,
	comment_count int default 0,
	view_count int default 0,
	like_count int default 0,
	tag varchar(255),
	constraint question_pk
		primary key (id)
);

