create table AD
(
    ID         int auto_increment primary key,
    TITLE      VARCHAR(256) default null,
    url        VARCHAR(512)  default null,
    image      VARCHAR(256) default null,
    GMT_CREATE BIGINT,
    GMT_MODIFY BIGINT,
    GMT_START bigint,
    GMT_END bigint,
    status int,
    pos varchar(10) not null
);

