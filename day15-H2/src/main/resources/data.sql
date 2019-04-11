insert into users(username,password,enabled) values('1','1',true);
insert into users(username,password,enabled) values('2','2',true);
insert into users(username,password,enabled) values('3','3',true);
insert into users(username,password,enabled) values('4','4',true);

insert into authorities(username,authority) values('1','ROLE_USER');
insert into authorities(username,authority) values('2','ROLE_ADMIN');
--insert into authorities(username,authority) values('3','read');
--insert into authorities(username,authority) values('4','read');
insert into permissions(authority, url) values('ROLE_USER','/');
insert into permissions(authority, url) values('ROLE_ADMIN','/user');
insert into permissions(authority, url) values('ROLE_ADMIN','/admin');