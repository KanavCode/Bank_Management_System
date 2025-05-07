create database Banking;

use Banking;

create table signup(formno varchar(20), name varchar(30), father_name varchar(30) ,dob varchar(20),gender varchar(20),email varchar(100), marital_status varchar(20), address varchar(100), city varchar(20), state varchar(20), pin varchar(10)); 
select *from signup;

show tables;

select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20) ,income varchar(20),education varchar(20),occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingAccount varchar(20)); 
select * from signuptwo;

create table signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25) ,pin varchar(20),facility varchar(100));
select * from signupthree;

 create table login(formno varchar(20),cardnumber varchar(25),pin varchar(10));
select * from login;

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
select * from bank;	