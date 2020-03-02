create table notification(
  id bigint primary key auto_increment,
  notifier bigint not null,
  notifier_name varchar(50) not null,
  receiver bigint not null,
  outer_id bigint not null,
  outer_title varchar(200) not null,
  type int not null,
  gmt_create bigint not null,
  status int default 0 not null
);