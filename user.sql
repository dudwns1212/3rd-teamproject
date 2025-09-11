create schema gymproject;
use gymproject;

create table users(
	user_id int auto_increment primary key,
    user_email varchar(50) unique,
    user_password varchar(50),
    user_name varchar(30),
    user_tel varchar(30),
    user_birth varchar(30),
    user_gender varchar(10)
);




select * from users;
select * from gymusers;