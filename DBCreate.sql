drop database if exists hrdsystem;
create database hrdsystem;
use hrdsystem;

drop table if exists directory;
create table directory(
	dno int auto_increment,
    dname varchar(20) not null unique,
    dcontact varchar(20) not null,
    primary key (dno)
);

drop table if exists personnel;
create table personnel(
	pno int auto_increment,
    pname varchar(10) not null unique,
    pcontact varchar(20) not null,
    prank varchar(10) not null,
    dno int,
    primary key (pno),
    foreign key (dno) references directory(dno)
);

insert into directory(dname,dcontact) values ("부서1", "111-111-1111");
insert into directory(dname,dcontact) values ("부서2", "222-222-2222");
insert into directory(dname,dcontact) values ("부서3", "333-333-3333");
insert into directory(dname,dcontact) values ("부서4", "444-444-4444");

insert into personnel(pname,pcontact,prank, dno) values ("유재석", "010-111-1111", "사원", 1);
insert into personnel(pname,pcontact,prank, dno) values ("강호동", "010-222-2222", "사원", 2);
insert into personnel(pname,pcontact,prank, dno) values ("신동엽", "010-111-2222", "사원", 3);
insert into personnel(pname,pcontact,prank, dno) values ("하하", "010-111-3333", "사원", 4);