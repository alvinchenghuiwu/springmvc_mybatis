--Mysql 5.6

CREATE DATABASE wolf;

create table user(
id int  AUTO_INCREMENT  primary key,
name varchar(25) not null,
pwd varchar(20) not null,
create_time date
)

insert into user(name,pwd,create_time) values("wangxin","123","2014-02-14");
insert into user(name,pwd,create_time) values("Tom","123456","2014-02-14");
insert into user(name,pwd,create_time) values("Jack","123","2014-02-14");
insert into user(name,pwd,create_time) values("Bob","123","2014-02-14");